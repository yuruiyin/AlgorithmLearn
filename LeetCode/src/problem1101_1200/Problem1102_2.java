package problem1101_1200;

public class Problem1102_2 {

    private int[][] grid;
    private int rowCount;
    private int colCount;
    private int[][] prevPathMinArr; // 到达每个单元格的路径中的最小值
    private int ansMax = 0;
//    private int[] dx = new int[]{-1, 1, 0, 0};
//    private int[] dy = new int[]{0, 0, -1, 1};

    private void backTrack(int row, int col, int min, boolean[][] visited) {
        if (grid[row][col] < min) {
            min = grid[row][col];
        }

        if (min <= ansMax || min <= prevPathMinArr[row][col]) {
            // 当前路径到达这个单元的路径最小值小于之前到达此单元格的路径最小值
            return;
        }

        prevPathMinArr[row][col] = min;
        if (row == rowCount - 1 && col == colCount - 1) {
            ansMax = min;
            return;
        }

        visited[row][col] = true;

        if (row > 0 && !visited[row-1][col]) {
            backTrack(row-1, col, min, visited);
        }

        if (row < rowCount - 1 && !visited[row+1][col]) {
            backTrack(row+1, col, min, visited);
        }

        if (col > 0 && !visited[row][col-1]) {
            backTrack(row, col-1, min, visited);
        }

        if (col < colCount - 1 && !visited[row][col+1]) {
            backTrack(row, col+1, min, visited);
        }

        // 如果用以下for循环的写法，会超时，因此每次for循环里面判断的东西比以上写法多一点
//        for (int i = 0; i < 4; i++) {
//            int nextRow = row + dx[i];
//            int nextCol = col + dy[i];
//
//            if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount || visited[nextRow][nextCol]) {
//                continue;
//            }
//
//            backTrack(nextRow, nextCol, min, visited);
//        }

        visited[row][col] = false;
    }

    public int maximumMinimumPath(int[][] grid) {
        this.grid = grid;
        rowCount = grid.length;
        colCount = grid[0].length;
        prevPathMinArr = new int[rowCount][colCount];
        backTrack(0, 0, Integer.MAX_VALUE, new boolean[rowCount][colCount]);
        return ansMax;
    }

}
