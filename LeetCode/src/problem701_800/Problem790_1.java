package problem701_800;

import java.util.Arrays;

public class Problem790_1 {

    private static final int MOD = (int) (1e9 + 7);

    private long[][] memo;

    private int n;

    private long rec(int preStatus, int curIdx) {
        if (curIdx > n) {
            return 0;
        }
        if (curIdx == n) {
            return preStatus == 0b11 ? 1 : 0;
        }

        if (memo[preStatus][curIdx] != -1) {
            return memo[preStatus][curIdx];
        }

        if (preStatus == 0b11) {
            // 前面均已铺满，直接从当前curIdx开始铺
            return memo[preStatus][curIdx] = (
                    rec(0b11, curIdx + 1)
                            + rec(0b11, curIdx + 2)
                            + rec(0b01, curIdx + 2)
                            + rec(0b10, curIdx + 2)
            ) % MOD;
        } else if (preStatus == 0b01) {
            return memo[preStatus][curIdx] = (rec(0b10, curIdx + 1) + rec(0b11, curIdx + 1)) % MOD;
        } else  {
            // preStatus == 0b10
            return memo[preStatus][curIdx] = (rec(0b01, curIdx + 1) + rec(0b11, curIdx + 1)) % MOD;
        }
    }

    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        this.n = n;
        this.memo = new long[4][n];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(memo[i], -1);
        }
        return (int) (rec(0b11, 0) % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new Problem790_1().numTilings(2));
        System.out.println(new Problem790_1().numTilings(3));
    }

}
