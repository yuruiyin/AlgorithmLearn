package contest.contest394;

import java.util.Arrays;

public class C {

    private Integer[][] memo;
    private int[][] grid;
    private int m;
    private int n;

    private int[][] colCountArr;

    private int rec(int left, int idx) {
        if (idx == n) {
            return 0;
        }

        if (memo[left][idx] != null) {
            return memo[left][idx];
        }

        int resMin = 1000000;
        for (int i = 0; i <= 9; i++) {
            if (i != left) {
                resMin = Math.min(resMin, rec(i, idx + 1) + m - colCountArr[idx][i]);
            }
        }

        return memo[left][idx] = resMin;
    }

    public int minimumOperations(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        colCountArr = new int[n][10];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colCountArr[j][grid[i][j]]++;
            }
        }

        memo = new Integer[11][1001];
        return rec(10, 0);
    }
}
