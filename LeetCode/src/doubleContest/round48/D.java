package doubleContest.round48;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/20
 */
public class D {

    private int[] arr;
    private int len;
    private int[] memo;
    private int[][] gcdArr;

    private int gcd(int m, int n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }

    private int dp(int num, int idx) {
        if (num == 0) {
            return 0;
        }

        int key = (num << 3) + idx;
        if (memo[key] != 0) {
            return memo[key];
        }

        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            if ((num & (1 << i)) != 0) {
                // 说明这一位可以选
                for (int j = 0; j < len; j++) {
                    if (j == i) {
                        continue;
                    }

                    if ((num & (1 << j)) != 0) {
                        ansMax = Math.max(ansMax, idx * gcdArr[i][j] + dp(num ^ (1 << i) ^ (1 << j), idx + 1));
                    }
                }
            }
        }

        memo[key] = ansMax;
        return ansMax;
    }

    private void calcGcd() {
        gcdArr = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                gcdArr[i][j] = gcd(arr[i], arr[j]);
            }
        }
    }

    public int maxScore(int[] nums) {
        arr = nums;
        len = arr.length;
        memo = new int[1 << (len + 3)];
        calcGcd();
        return dp((1 << len) - 1, 1);
    }

}
