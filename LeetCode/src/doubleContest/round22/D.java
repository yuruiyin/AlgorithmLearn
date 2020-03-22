package doubleContest.round22;

/**
 * A
 *
 * @author: yry
 * @date: 2020/3/21
 */
public class D {

    private int[] arr;
    private Integer[][][] memo;
    private int len;
    private int[] suffixMax;
    private int[] suffixMax1; // 不包含最后一个

    private int dp(int zeroChoose, int idx, int k) {
        if (k == 0) {
            return 0;
        }

        if (len - idx - zeroChoose < k || idx >= len) {
            return Integer.MIN_VALUE;
        }

        if (k == 1) {
            return zeroChoose == 0 ? suffixMax[idx] : suffixMax1[idx];
        }

        if (memo[zeroChoose][idx][k] != null) {
            return memo[zeroChoose][idx][k];
        }

        int choose = dp(zeroChoose, idx + 2, k - 1) + arr[idx];
        int nonChoose = dp(zeroChoose, idx + 1, k);
        memo[zeroChoose][idx][k] = Math.max(choose, nonChoose);
        return memo[zeroChoose][idx][k];
    }

    private void calcSuffixMax() {
        suffixMax = new int[len];
        suffixMax1 = new int[len];
        suffixMax[len - 1] = arr[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        }

        suffixMax1[len - 2] = arr[len - 2];
        for (int i = len - 3; i >= 0; i--) {
            suffixMax1[i] = Math.max(suffixMax1[i + 1], arr[i]);
        }
    }

    public int maxSizeSlices(int[] slices) {
        len = slices.length;
        this.arr = slices;
        memo = new Integer[2][len][len / 3 + 1];
        int count = len / 3;
        calcSuffixMax();
        return Math.max(dp(0, 1, count), dp(1, 2, count - 1) + arr[0]);
    }

}
