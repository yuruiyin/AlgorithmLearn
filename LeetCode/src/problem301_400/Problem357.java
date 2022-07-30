package problem301_400;

import java.util.Arrays;

public class Problem357 {

    private int[][] memo;

    private int dp(int idx, int visited, int n) {
        if (idx == n) {
            return visited != 0 ? 1 : 0;
        }

        if (memo[idx][visited] != -1) {
            return memo[idx][visited];
        }

        // 当前可以选或者不选
        int ans = 0;
        int start = visited == 0 ? 1 : 0;
        for (int i = start; i < 10; i++) {
            if ((visited & (1 << i)) != 0) {
                // 前面已经用过
                continue;
            }
            visited |= (1 << i);
            ans += dp(idx + 1, visited, n);
            visited ^= (1 << i);
        }

        memo[idx][visited] = ans;
        return ans;
    }

    public int countNumbersWithUniqueDigits(int n) {
        memo = new int[n][1 << 10];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[j], -1);
            }
            ans += dp(0, 0, i);
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem357().countNumbersWithUniqueDigits(2));
        System.out.println(new Problem357().countNumbersWithUniqueDigits(1));
        System.out.println(new Problem357().countNumbersWithUniqueDigits(0));
    }

}
