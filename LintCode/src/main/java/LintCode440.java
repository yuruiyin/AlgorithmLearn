import java.util.Arrays;

/**
 * LintCode440
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode440 {

    private int[] dimenArr;
    private int[] valArr;
    private int len;
    private int[] memo;

    private int dp(int m) {
        if (m < 0) {
            return Integer.MIN_VALUE;
        }

        if (m == 0) {
            return 0;
        }

        if (memo[m] != -1) {
            return memo[m];
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, dp(m - dimenArr[i]) + valArr[i]);
        }
        memo[m] = max;
        return max;
    }

    public int backPackIII(int[] dimenArr, int[] valArr, int m) {
        // write your code here
        this.dimenArr = dimenArr;
        this.valArr = valArr;
        this.len = dimenArr.length;
        memo = new int[m + 1];
        Arrays.fill(memo, -1);
        return dp(m);
    }

}
