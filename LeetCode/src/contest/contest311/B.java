package contest.contest311;

public class B {

    public int longestContinuousSubstring(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ansMax = 1;
        int pre = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                pre++;
                ansMax = Math.max(ansMax, pre);
            } else {
                pre = 1;
            }
        }
        return ansMax;
    }

}
