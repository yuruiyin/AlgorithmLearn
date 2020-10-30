package contest.contest212;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/25
 */
public class C {

    private int rowCount;
    private int colCount;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private boolean dfs(int[][] heights, int row, int col, boolean[][] visited, int maxD) {
        visited[row][col] = true;
        if (row == rowCount - 1 && col == colCount - 1) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount || visited[nextRow][nextCol]) {
                continue;
            }

            if (Math.abs(heights[nextRow][nextCol] - heights[row][col]) > maxD) {
                continue;
            }

            boolean isFound = dfs(heights, nextRow, nextCol, visited, maxD);
            if (isFound) {
                return true;
            }
        }

        return false;
    }

    private boolean isOk(int[][] heights, int maxD) {
        return dfs(heights, 0, 0, new boolean[rowCount][colCount], maxD);
    }

    public int minimumEffortPath(int[][] heights) {
        // 二分
        rowCount = heights.length;
        colCount = heights[0].length;

        int l = 0;
        int r = 1000000;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (isOk(heights, mid)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

}
