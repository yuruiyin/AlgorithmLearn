package contest.contest305;

public class D {

    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        char[] arr = s.toCharArray();
        int len = arr.length;
        dp[arr[0] - 'a'] = 1;
        int ansMax = 1;
        for (int i = 1; i < len; i++) {
            char curC = arr[i];
            int value = 1;
            for (int j = 0; j < 26; j++) {
                if (Math.abs(curC - 'a' - j) <= k) {
                    value = Math.max(value, 1 + dp[j]);
                }
            }
            dp[curC - 'a'] = value;
            ansMax = Math.max(ansMax, dp[curC - 'a']);
        }
        return ansMax;
    }

}
