package contest.contest163;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem04 {

    public int minPushBox(char[][] grid) {
        // 先判断人是否可以到达箱子旁边
        // 如果可以到达，从箱子旁边开始推，计算最小路径

        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[] sIndex = new int[2];
        int[] bIndex = new int[2];
        int[] tIndex = new int[2];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 'S') {
                    sIndex = new int[]{i,j};
                } else if (grid[i][j] == 'B') {
                    bIndex = new int[]{i,j};
                } else if (grid[i][j] == 'T') {
                    tIndex = new int[]{i,j};
                }
            }
        }

        List<int[]> boxNeighborIndexList = new ArrayList<>();
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(sIndex);
        boolean[][] visited = new boolean[rowCount][colCount];
        visited[sIndex[0]][sIndex[1]] = true;

        while (!queue.isEmpty()) {
            List<int[]> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.removeFirst());
            }

            for (int[] node : nodeList) {
                int row = node[0];
                int col = node[1];

                // 上
                if (row > 0 && !visited[row - 1][col] && (grid[row-1][col] == '.' || grid[row-1][col] == 'T')) {
                    queue.add(new int[]{row-1, col});
                    visited[row - 1][col] = true;
                }

                // 下
                if (row < rowCount - 1 && !visited[row + 1][col] && (grid[row+1][col] == '.' || grid[row+1][col] == 'T')) {
                    queue.add(new int[]{row+1, col});
                    visited[row + 1][col] = true;
                }

                // 左
                if (col > 0 && !visited[row][col-1] && (grid[row][col-1] == '.' || grid[row][col-1] == 'T')) {
                    queue.add(new int[]{row, col-1});
                    visited[row][col-1] = true;
                }

                // 右
                if (col < colCount - 1 && !visited[row][col+1] && (grid[row][col+1] == '.' || grid[row][col+1] == 'T')) {
                    queue.add(new int[]{row, col+1});
                    visited[row][col+1] = true;
                }

                // 上
                if (row > 0 && (grid[row-1][col] == 'B')) {
                    boxNeighborIndexList.add(node);
                }

                // 下
                if (row < rowCount - 1 && (grid[row+1][col] == 'B')) {
                    boxNeighborIndexList.add(node);
                }

                // 左
                if (col > 0 &&  (grid[row][col-1] == 'B')) {
                    boxNeighborIndexList.add(node);
                }

                // 右
                if (col < colCount - 1 && (grid[row][col+1] == 'B')) {
                    boxNeighborIndexList.add(node);
                }

            }
        }

        if (boxNeighborIndexList.isEmpty()) {
            return -1;
        }

        // TODO

        return 0;
    }
    
    public static void main(String[] args) {
        
    }
    
}
