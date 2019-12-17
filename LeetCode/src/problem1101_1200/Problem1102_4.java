package problem1101_1200;

public class Problem1102_4 {

    private int[][] grid;
    private int rowCount;
    private int colCount;
//    private int[] dx = new int[]{-1, 1, 0, 0};
//    private int[] dy = new int[]{0, 0, -1, 1};

    private boolean isValid(int row, int col, int limit, boolean[][] visited) {
        visited[row][col] = true;
        if (row == rowCount - 1 && col == colCount - 1) {
            return true;
        }

        if (row > 0 && !visited[row-1][col] && grid[row-1][col] >= limit) {
            if (isValid(row-1, col, limit, visited)) {
                return true;
            }
        }

        if (row < rowCount - 1 && !visited[row+1][col] && grid[row+1][col] >= limit) {
            if (isValid(row+1, col, limit, visited)) {
                return true;
            }
        }

        if (col > 0 && !visited[row][col-1] && grid[row][col-1] >= limit) {
            if (isValid(row, col-1, limit, visited)) {
                return true;
            }
        }

        if (col < colCount - 1 && !visited[row][col+1] && grid[row][col+1] >= limit) {
            if (isValid(row, col+1, limit, visited)) {
                return true;
            }
        }

        // 下面for循环的方式会比上面的慢一点
//        for (int i = 0; i < 4; i++) {
//            int nextRow = row + dx[i];
//            int nextCol = col + dy[i];
//
//            if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount
//                    || visited[nextRow][nextCol] || grid[nextRow][nextCol] < limit) {
//                continue;
//            }
//
//            if (isValid(nextRow, nextCol, limit, visited)) {
//                return true;
//            }
//        }

        return false;
    }

    // 二分
    public int maximumMinimumPath(int[][] grid) {
        this.grid = grid;
        rowCount = grid.length;
        colCount = grid[0].length;
        int low = 0;
        int high = Math.min(grid[0][0], grid[rowCount - 1][colCount -1]);  // 所有路径的最小值不会超过头尾最小值
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (isValid(0, 0, mid, new boolean[rowCount][colCount])) {
                // 存在路径得分大于mid，就寻找看看有没有更大的
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

}
