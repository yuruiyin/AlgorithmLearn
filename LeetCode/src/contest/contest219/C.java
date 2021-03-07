package contest.contest219;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/13
 */
public class C {

    private int[] preSumArr;
    private int[] arr;
    private int len;
    private Integer[][] memo;

    private int dp(int l, int r) {
        if (l >= r) {
            return 0;
        }

        if (memo[l][r] != null) {
            return memo[l][r];
        }

        // 求最大
        int res1 = preSumArr[r] - preSumArr[l] - dp(l + 1, r);
        int res2 = preSumArr[r - 1] - (l == 0 ? 0 : preSumArr[l - 1]) - dp(l , r - 1);
        memo[l][r] = Math.max(res1, res2);
        return memo[l][r];
    }

    private void calcPreSumArr() {
        preSumArr = new int[len];
        preSumArr[0] = arr[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + arr[i];
        }
    }

    public int stoneGameVII(int[] arr) {
        this.arr = arr;
        len = arr.length;
        calcPreSumArr();
        memo = new Integer[len][len];
        return dp(0, len - 1);
    }

}
