package problem301_400;

public class Problem343 {

    /**
     * 将整数拆分成的数字之差最大为1，如8拆分成2+3+3
     * @param n 整数n
     * @param m 拆分成m段
     * @return 返回拆分成m段的最大值
     */
    private int getAns(int n, int m) {
        int ans = 1;
        int eachLen = n / m;
        int remain = n - eachLen * m;
        int left = m - remain;
        int right = remain;
        while ((right--) > 0) {
            ans *= eachLen + 1;
        }

        while ((left--) > 0) {
            ans *= eachLen;
        }

        return ans;
    }

    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }

        int m = (int) Math.sqrt(n);
        int max = 0;
        for (int i = m; i <= n; i++) {
            max = Math.max(max, getAns(n, i));
        }
        return max;
    }

}
