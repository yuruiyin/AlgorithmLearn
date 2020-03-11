package problem1201_1300;

public class Problem1218_1 {

    private final static int MAX = 10000;

    public int longestSubsequence(int[] arr, int difference) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            arr[i] += MAX;
        }

        int[] dp = new int[3 * MAX + 1];
        dp[arr[0]] = 1;
        int ansMax = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] - difference < 0) {
                dp[arr[i]] = 1;
                continue;
            }

            dp[arr[i]] = dp[arr[i] - difference] + 1;
            ansMax = Math.max(ansMax, dp[arr[i]]);
        }

        return ansMax;
    }

}
