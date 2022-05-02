package doubleContest.round77;

public class C {

    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        // 0: 空格，1: guards, 2: wall
        for (int[] g : guards) {
            int i = g[0];
            int j = g[1];
            grid[i][j] = 1;
        }

        for (int[] w : walls) {
            int i = w[0];
            int j = w[1];
            grid[i][j] = 2;
        }

        boolean[][] leftHasG = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            boolean hasG = false;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    hasG = true;
                } else if (grid[i][j] == 2) {
                    hasG = false;
                } else {
                    leftHasG[i][j] = hasG;
                }
            }
        }

        boolean[][] rightHasG = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            boolean hasG = false;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    hasG = true;
                } else if (grid[i][j] == 2) {
                    hasG = false;
                } else {
                    rightHasG[i][j] = hasG;
                }
            }
        }

        boolean[][] topHasG = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            boolean hasG = false;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    hasG = true;
                } else if (grid[i][j] == 2) {
                    hasG = false;
                } else {
                    topHasG[i][j] = hasG;
                }
            }
        }

        boolean[][] bottomHasG = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            boolean hasG = false;
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == 1) {
                    hasG = true;
                } else if (grid[i][j] == 2) {
                    hasG = false;
                } else {
                    bottomHasG[i][j] = hasG;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }

                if (leftHasG[i][j] || rightHasG[i][j] || topHasG[i][j] || bottomHasG[i][j]) {
                    continue;
                }
                ans++;
            }
        }
        return ans;
    }


}
