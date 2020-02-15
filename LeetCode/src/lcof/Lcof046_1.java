package lcof;

public class Lcof046_1 {

    public int translateNum(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int twoDigitNum = (arr[i - 1] - '0') * 10 + (arr[i] - '0');
            if (twoDigitNum > 25 || arr[i-1] == '0') {
                dp[i] = dp[i-1];
                continue;
            }

            if (i == 1) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[len - 1];
    }

}
