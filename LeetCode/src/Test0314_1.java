import java.util.Arrays;

public class Test0314_1 {

    private static final int MOD = 10000;
    private int[] memo;

    private int dp(int pre1, int pre2) {
        int abs = Math.abs(pre1 - pre2);
        if (memo[abs] != -1) {
            return memo[abs];
        }

        long ans = 1;
        for (int i = 1; i < abs; i++) {
            ans = (ans + dp(pre2, i)) % MOD;
        }

        memo[abs] = (int) ans;
        return memo[abs];
    }

    private int getAns(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = (ans + dp(n, i)) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Test0314_1().getAns(1000));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");

    }

}
