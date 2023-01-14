package problem701_800;

import java.util.Arrays;

public class Problem790 {

    private static final int MOD = (int) (1e9 + 7);

    private long[][] memo;

    private int n;

    private long rec(int preStatus, int curIdx) {
        if (curIdx > n) {
            return 0;
        }
        if (curIdx == n) {
            if (preStatus == 0b1111) {
                return 1;
            } else if (preStatus == 0b1100) {
                return 1;
            }
            return 0;
        }

        if (memo[preStatus][curIdx] != -1) {
            return memo[preStatus][curIdx];
        }

        if (preStatus == 0b1111) {
            // 前面均已铺满，直接从当前curIdx开始铺
            return memo[preStatus][curIdx] = (
                    rec(0b1100, curIdx + 2)
                            + rec(0b1111, curIdx + 1)
                            + rec(0b1011, curIdx + 2)
                            + rec(0b1110, curIdx + 2)
            ) % MOD;
        } else if (preStatus == 0b1100) {
            return memo[preStatus][curIdx] = rec(0b1111, curIdx) % MOD;
        } else if (preStatus == 0b1011) {
            return memo[preStatus][curIdx] = (
                    rec(0b1111, curIdx + 1) + rec(0b1110, curIdx + 1)
            ) % MOD;
        } else {
            // 0b1110
            return memo[preStatus][curIdx] = (
                    rec(0b1111, curIdx + 1) + rec(0b1011, curIdx + 1)
            ) % MOD;
        }
    }

    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        this.n = n;
        this.memo = new long[16][n];
        for (int i = 0; i < 16; i++) {
            Arrays.fill(memo[i], -1);
        }
        return (int) (rec(0b1111, 0) % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new Problem790().numTilings(2));
        System.out.println(new Problem790().numTilings(3));
    }

}
