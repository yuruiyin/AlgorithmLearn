package doubleContest.round46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/20
 */
public class C {

    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public int[][] highestPeak(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<int[]> indexList = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    indexList.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int cur = 1;
        List<int[]> tmpIndexList = new ArrayList<>();

        while (!indexList.isEmpty()) {
            tmpIndexList.clear();
            for (int[] pos : indexList) {
                int row = pos[0];
                int col = pos[1];
                for (int i = 0; i < 4; i++) {
                    int nextRow = row + dx[i];
                    int nextCol = col + dy[i];
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                        continue;
                    }

                    visited[nextRow][nextCol] = true;
                    ans[nextRow][nextCol] = cur;
                    tmpIndexList.add(new int[]{nextRow, nextCol});
                }
            }
            indexList.clear();
            for (int[] idx : tmpIndexList) {
                indexList.add(idx);
            }
            cur++;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int[][] ans = new C().highestPeak(new int[][]{{0, 1}, {0, 0}});
    }

}
