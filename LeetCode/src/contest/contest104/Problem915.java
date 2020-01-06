package contest.contest104;

public class Problem915 {

    public int partitionDisjoint(int[] arr) {
        int len = arr.length;
        int[] prefixMaxArr = new int[len];
        int[] suffixMinArr = new int[len];

        prefixMaxArr[0] = arr[0];
        for (int i = 1; i < len; i++) {
            prefixMaxArr[i] = Math.max(arr[i], prefixMaxArr[i - 1]);
        }

        suffixMinArr[len-1] = arr[len-1];
        for (int i = len - 2; i >= 0; i--) {
            suffixMinArr[i] = Math.min(arr[i], suffixMinArr[i+1]);
        }

        for (int i = 0; i < len - 1; i++) {
            if (prefixMaxArr[i] <= suffixMinArr[i+1]) {
                return i + 1;
            }
        }

        return 0;
    }

}
