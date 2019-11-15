package problem1001_1100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem1034 {

    class Node {
        int row;
        int col;
        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        List<Node> positions = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(r0, c0));
        int curColor = grid[r0][c0];
        boolean[][] visited = new boolean[rowCount][colCount];
        visited[r0][c0] = true;

        while (!queue.isEmpty()) {
            List<Node> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                Node node = queue.removeFirst();
                nodeList.add(node);
                positions.add(node);
            }
            
            for (Node node: nodeList) {
                int row = node.row;
                int col = node.col;
                // 上
                if (row > 0 && grid[row-1][col] == curColor && !visited[row-1][col]) {
                    queue.add(new Node(row-1, col));
                    visited[row-1][col] = true;
                }

                // 上
                if (row < rowCount - 1 && grid[row+1][col] == curColor && !visited[row+1][col]) {
                    queue.add(new Node(row+1, col));
                    visited[row+1][col] = true;
                }

                // 左
                if (col > 0 && grid[row][col-1] == curColor && !visited[row][col-1]) {
                    queue.add(new Node(row, col-1));
                    visited[row][col-1] = true;
                }

                // 左
                if (col < colCount - 1 && grid[row][col+1] == curColor && !visited[row][col+1]) {
                    queue.add(new Node(row, col+1));
                    visited[row][col+1] = true;
                }
            }
        }

        int[][] oldGrid = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                oldGrid[i][j] = grid[i][j];
            }
        }

        for (Node node: positions) {
            int row = node.row;
            int col = node.col;
            if (row == 0 || row == rowCount - 1 || col == 0 || col == colCount - 1) {
                grid[row][col] = color;
                continue;
            }

            if (oldGrid[row-1][col] != curColor || oldGrid[row+1][col] != curColor
                    || oldGrid[row][col-1] != curColor || oldGrid[row][col+1] != curColor) {
                grid[row][col] = color;
            }
        }

        return grid;
    }
    
    public static void main(String[] args) {
        
    }
    
}
