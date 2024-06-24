package contest.contest403;

public class D {

    private int calcMinArea(int[][] grid, int leftRow, int leftCol, int rightRow, int rightCol) {
        int minRow = rightRow;
        int maxRow = leftRow;
        int minCol = rightCol;
        int maxCol = leftCol;
        boolean hasOneGrid = false;
        for (int i = leftRow; i <= rightRow; i++) {
            for (int j = leftCol; j <= rightCol; j++) {
                if (grid[i][j] == 1) {
                    hasOneGrid = true;
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        if (!hasOneGrid) {
            return -1;
        }

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

    public int minimumSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 分类讨论，6种分割方法
        // case 1
        int ansMin = m * n;
        for (int col1 = 0; col1 < n - 2; col1++) {
            for (int col2 = col1 + 1; col2 < n - 1; col2++) {
                int area1 = calcMinArea(grid, 0, 0, m - 1, col1);
                int area2 = calcMinArea(grid, 0, col1 + 1, m - 1, col2);
                int area3 = calcMinArea(grid, 0, col2 + 1, m - 1, n - 1);
                if (area1 != -1 && area2 != -1 && area3 != -1) {
                    ansMin = Math.min(ansMin, area1 + area2 + area3);
                }
            }
        }

        // case 2
        for (int row1 = 0; row1 < m - 2; row1++) {
            for (int row2 = row1 + 1; row2 < m - 1; row2++) {
                int area1 = calcMinArea(grid, 0, 0, row1, n - 1);
                int area2 = calcMinArea(grid, row1 + 1, 0, row2, n - 1);
                int area3 = calcMinArea(grid, row2 + 1, 0, m - 1, n - 1);
                if (area1 != -1 && area2 != -1 && area3 != -1) {
                    ansMin = Math.min(ansMin, area1 + area2 + area3);
                }
            }
        }

        // case 3
        for (int row = 0; row < m - 1; row++) {
            for (int col = 0; col < n - 1; col++) {
                int area1 = calcMinArea(grid, 0, 0, row, col);
                int area2 = calcMinArea(grid, 0, col + 1, row, n - 1);
                int area3 = calcMinArea(grid, row + 1, 0, m - 1, n - 1);
                if (area1 != -1 && area2 != -1 && area3 != -1) {
                    ansMin = Math.min(ansMin, area1 + area2 + area3);
                }
            }
        }

        // case 4
        for (int row = 0; row < m - 1; row++) {
            for (int col = 0; col < n - 1; col++) {
                int area1 = calcMinArea(grid, 0, 0, row, n - 1);
                int area2 = calcMinArea(grid, row + 1, 0, m - 1, col);
                int area3 = calcMinArea(grid, row + 1, col + 1, m - 1, n - 1);
                if (area1 != -1 && area2 != -1 && area3 != -1) {
                    ansMin = Math.min(ansMin, area1 + area2 + area3);
                }
            }
        }

        // case 5
        for (int row = 0; row < m - 1; row++) {
            for (int col = 0; col < n - 1; col++) {
                int area1 = calcMinArea(grid, 0, 0, m - 1, col);
                int area2 = calcMinArea(grid, 0, col + 1, row, n - 1);
                int area3 = calcMinArea(grid, row + 1, col + 1, m - 1, n - 1);
                if (area1 != -1 && area2 != -1 && area3 != -1) {
                    ansMin = Math.min(ansMin, area1 + area2 + area3);
                }
            }
        }

        // case 6
        for (int row = 0; row < m - 1; row++) {
            for (int col = 0; col < n - 1; col++) {
                int area1 = calcMinArea(grid, 0, 0, row, col);
                int area2 = calcMinArea(grid, row + 1, 0, m - 1, col);
                int area3 = calcMinArea(grid, 0, col + 1, m - 1, n - 1);
                if (area1 != -1 && area2 != -1 && area3 != -1) {
                    ansMin = Math.min(ansMin, area1 + area2 + area3);
                }
            }
        }

        return ansMin;
    }

}
