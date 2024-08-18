package contest.contest409;

public class A {

    static class neighborSum {

        private int[][] grid;

        private int n;
        private int[][] pos = new int[100][2];

        public neighborSum(int[][] grid) {
            this.n = grid.length;
            this.grid = grid;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    pos[grid[i][j]] = new int[2];
                    pos[grid[i][j]][0] = i;
                    pos[grid[i][j]][1] = j;
                }
            }
        }

        public int adjacentSum(int value) {
            int i = pos[value][0];
            int j = pos[value][1];
            int ans = 0;
            if (i > 0) {
                ans += grid[i - 1][j];
            }

            if (i < n - 1) {
                ans += grid[i + 1][j];
            }

            if (j > 0) {
                ans += grid[i][j - 1];
            }

            if (j < n - 1) {
                ans += grid[i][j + 1];
            }

            return ans;
        }

        public int diagonalSum(int value) {
            int i = pos[value][0];
            int j = pos[value][1];
            int ans = 0;
            if (i > 0) {
                if (j > 0) {
                    ans += grid[i - 1][j - 1];
                }
                if (j < n - 1) {
                    ans += grid[i - 1][j + 1];
                }
            }

            if (i < n - 1) {
                if (j > 0) {
                    ans += grid[i + 1][j - 1];
                }
                if (j < n - 1) {
                    ans += grid[i + 1][j + 1];
                }
            }

            return ans;
        }
    }

}
