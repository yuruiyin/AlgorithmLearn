package lcof;

public class Lcof049 {

    // DP+三指针
    // 因为一个丑数就是不断的乘2，乘3，乘5
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];  // dp[i] 存放第i个丑数
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = Math.min(2 * dp[i2], Math.min(3 * dp[i3], 5 * dp[i5]));
            if (min == 2 * dp[i2]) {
                i2++;
            }
            if (min == 3 * dp[i3]) {
                i3++;
            }
            if (min == 5 * dp[i5]) {
                i5++;
            }
            dp[i] = min;
        }

        return dp[n-1];
    }

}
