package contest.contest116;

public class Problem961_1 {

    public int repeatedNTimes(int[] arr) {
        int[] countArr = new int[10001];
        for (int num : arr) {
            countArr[num]++;
            if (countArr[num] > 1) {
                return num;
            }
        }
        return -1;
    }

}
