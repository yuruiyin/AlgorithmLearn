package lcci;


// TLE
public class Lcci0811 {

    private static final int MOD = (int) (1e9 + 7);
    private int[] arr;
    private int len;
    private Integer[][] memo;

    private int rec(int from, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (from == len) {
            return 0;
        }

        if (from >= 1 && n % 5 != 0) {
            return 0;
        }

        if (memo[from][n] != null) {
            return memo[from][n];
        }

        long ans = 0;
        int curNum = arr[from];
        int count = 0;

        while (count * curNum <= n) {
            ans = (ans + rec(from + 1, n - count * curNum)) % MOD;
            count++;
        }

        memo[from][n] = (int) ans;
        return memo[from][n];
    }

    public int waysToChange(int n) {
        arr = new int[]{1, 5, 10, 25};
        len = arr.length;
        memo = new Integer[len][n + 1];
        return rec(0, n);
    }

}
