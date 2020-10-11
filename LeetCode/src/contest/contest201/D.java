package contest.contest201;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/9
 */
public class D {

    private static final int MAX = 100000000;

    private int[] arr;
    private int[][] memo;

    private int dp(int l, int r) {
        if (l > r) {
            return 0;
        }

        if (l == r) {
            return arr[r + 1] - arr[l - 1];
        }

        if (memo[l][r] != -1) {
            return memo[l][r];
        }

        int ans = MAX;
        for (int i = l; i <= r; i++) {
            int tmp = dp(l, i - 1) + dp(i + 1, r) + arr[r + 1] - arr[l - 1];
            ans = Math.min(ans, tmp);
        }

        memo[l][r] = ans;
        return ans;
    }

    public int minCost(int n, int[] cuts) {
        if (cuts.length == 1) {
            return n;
        }

        arr = new int[cuts.length + 2];
        int len = arr.length;
        for (int i = 1; i < len - 1; i++) {
            arr[i] = cuts[i - 1];
        }
        arr[len - 1] = n;

        Arrays.sort(arr);
        memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(1, len - 2);
    }
    
    public static void main(String[] args) {
        System.out.println(new D().minCost(9, new int[]{5,6,1,4,2}));
        System.out.println(new D().minCost(5, new int[]{1, 3}));
    }

}
