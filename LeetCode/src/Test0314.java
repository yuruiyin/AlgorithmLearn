import java.util.Arrays;

public class Test0314 {

    private static final int MOD = 10000;
    private int[][] memo;

    private int dp(int pre1, int pre2) {
        if (memo[pre1][pre2] != -1) {
            return memo[pre1][pre2];
        }

        long ans = 1;
        int abs = Math.abs(pre1 - pre2);
        for (int i = 1; i < abs; i++) {
            ans = (ans + dp(pre2, i)) % MOD;
        }

        memo[pre1][pre2] = (int) ans;
        return memo[pre1][pre2];
    }

    private int getAns(int n) {
        int[] arr = new int[]{2, 3, 1};
        Integer[] arr1 = new Integer[]{2, 3, 1};
        Arrays.sort(arr);
        Arrays.sort(arr1);
        memo = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = (ans + dp(n, i)) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Test0314().getAns(1000));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");

    }

}
