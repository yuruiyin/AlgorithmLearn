package contest.contest246;

import java.util.LinkedList;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/20
 */
public class C {

    private int m;
    private int n;
    private final int[] dx = new int[]{-1, 1, 0, 0};
    private final int[] dy = new int[]{0, 0, -1, 1};

    private boolean isOk(int[][] grid1, int[][] grid2, int row, int col) {
        boolean flag = true;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        grid2[row][col] = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curNode = queue.poll();
                int curRow = curNode[0];
                int curCol = curNode[1];
                if (grid1[curRow][curCol] != 1) {
                    flag = false;
                }
                for (int j = 0; j < 4; j++) {
                    int nextRow = curRow + dx[j];
                    int nextCol = curCol + dy[j];
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || grid2[nextRow][nextCol] == 0) {
                        continue;
                    }

                    grid2[nextRow][nextCol] = 0;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }

        return flag;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid2.length;
        n = grid2[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 0) {
                    continue;
                }

                if (isOk(grid1, grid2, i, j)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
