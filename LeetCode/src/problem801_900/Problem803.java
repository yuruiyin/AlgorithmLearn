package problem801_900;

import utils.PrintUtil;

import java.util.Arrays;

/**
 * Problem803
 *
 * @author: yry
 * @date: 2020/3/16
 */
public class Problem803 {

    private boolean[][] visited;
    private int count = 0;
    private boolean isReachTop;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    private int m;
    private int n;
    private int[][] grid;

    private void dfs(int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || visited[row][col]) {
            return;
        }

        if (row == 0) {
            isReachTop = true;
        }

        count++;
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            dfs(nextRow, nextCol);
        }
    }

    private void changeState(int row, int col, boolean[][] curVisited) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || curVisited[row][col]) {
            return;
        }

        grid[row][col] = 0;
        curVisited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            changeState(nextRow, nextCol, curVisited);
        }
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        // 删除的不是砖块，别管他，其它也不会掉
        // 第一行的砖块都不会掉
        // 每删除一个砖块，遍历与他连通的砖块是否可以连通到第一行，如果不行，则就会掉落

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int len = hits.length;
        int[] ansArr = new int[len];
        visited = new boolean[m][n];
        boolean[][] curVisited = new boolean[m][n];
        for (int i = 0; i < len; i++) {
            int[] hit = hits[i];
            int row = hit[0];
            int col = hit[1];
            if (grid[row][col] == 0) {
                ansArr[i] = 0;
                continue;
            }

            for (int j = 0; j < m; j++) {
                Arrays.fill(visited[j], false);
            }
            grid[row][col] = 0;

            // 从第一行往其它遍历，能到达的都不会掉
            for (int j = 0; j < n; j++) {
                int curVal = grid[0][j];
                if (curVal == 0) {
                    continue;
                }


            }

            for (int j = 0; j < 4; j++) {
                int nextRow = row + dx[j];
                int nextCol = col + dy[j];
                count = 0;
                isReachTop = false;
                dfs(nextRow, nextCol);
                if (!isReachTop && count > 0) {
                    ansArr[i] += count;
                    for (int k = 0; k < m; k++) {
                        Arrays.fill(curVisited[k], false);
                    }
                    changeState(nextRow, nextCol, curVisited);
                }
            }
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,1,1,1,1,1},{1,1,1,1,1,1},{0,0,1,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}
        };

        int[][] hits = new int[][]{
                {1,3},{3,5},{0,3},{3,3},{1,1},{4,2},{1,0},{3,0},{4,5},{2,1},{4,4},{4,0},{2,4},{2,5},{3,4},{0,5},{0,4},{3,2},{1,5},{4,1},{2,2},{0,2}
        };

        int[] ans = new Problem803().hitBricks(grid, hits);
        PrintUtil.printIntArray(ans);
    }

}
