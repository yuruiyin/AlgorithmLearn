package problem1201_1300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem1254 {

    private boolean[][] visited;

    private boolean bfs(int[][] grid, int row, int col) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{row, col});
        visited[row][col] = true;

        boolean isClosedLand = true;

        while (!queue.isEmpty()) {
            List<int[]> ansList = new ArrayList<>();
            while (!queue.isEmpty()) {
                ansList.add(queue.removeFirst());
            }

            for (int[] node : ansList) {
                int curRow = node[0];
                int curCol = node[1];
                if (curRow == 0 || curRow == rowCount - 1 || curCol == 0 || curCol == colCount - 1) {
                    isClosedLand = false;
                }
                // 上
                if (curRow > 0 && grid[curRow-1][curCol] == 0 && !visited[curRow-1][curCol]) {
                    queue.add(new int[]{curRow-1, curCol});
                    visited[curRow-1][curCol] = true;
                }

                // 下
                if (curRow < rowCount - 1 && grid[curRow+1][curCol] == 0 && !visited[curRow+1][curCol]) {
                    queue.add(new int[]{curRow+1, curCol});
                    visited[curRow+1][curCol] = true;
                }

                // 左
                if (curCol > 0 && grid[curRow][curCol-1] == 0 && !visited[curRow][curCol-1]) {
                    queue.add(new int[]{curRow, curCol-1});
                    visited[curRow][curCol-1] = true;
                }

                // 右
                if (curCol < colCount - 1 && grid[curRow][curCol+1] == 0 && !visited[curRow][curCol+1]) {
                    queue.add(new int[]{curRow, curCol+1});
                    visited[curRow][curCol+1] = true;
                }
            }
        }

        return isClosedLand;
    }

    public int closedIsland(int[][] grid) {
        // bfs
        int rowCount = grid.length;
        int colCount = grid[0].length;
        visited = new boolean[rowCount][colCount];
        int ans = 0;
        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                if (grid[i][j] == 1 || visited[i][j]) {
                    continue;
                }

                boolean isClosedLand = bfs(grid, i, j);
                if (isClosedLand) {
                    ans++;
                }
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
