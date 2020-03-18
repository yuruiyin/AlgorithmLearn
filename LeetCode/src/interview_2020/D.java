package interview_2020;

/**
 * A
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class D {

    private Integer[][] memo;

    private int dp(int k, int n) {
        if (n <= 1 || k == 1) {
            return n;
        }

        if (memo[k][n] != null) {
            return memo[k][n];
        }

        int low = 1;
        int high = n;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int brokenRes = dp(k - 1, mid - 1);
            int nonBrokenRes = dp(k, n - mid);
            if (brokenRes > nonBrokenRes) {
                // 放太高了
                high = mid - 1;
                ans = Math.min(ans, brokenRes);
            } else {
                low = mid + 1;
                ans = Math.min(ans, nonBrokenRes);
            }
        }

        memo[k][n] = ans + 1;
        return memo[k][n];
    }

    public int superEggDrop(int k, int n) {
        memo = new Integer[k + 1][n + 1];
        return dp(k, n);
    }

    public static void main(String[] args) {
        System.out.println(new D().superEggDrop(2, 6));
    }

}
