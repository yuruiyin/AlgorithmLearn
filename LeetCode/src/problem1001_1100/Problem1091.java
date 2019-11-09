package problem1001_1100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem1091 {

    class Node {
        int row;
        int col;
        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;

        if (grid[0][0] == 1) {
            return -1;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(new Node(0, 0));
        boolean[][] visited = new boolean[rowCount][colCount];

        int ans = 1;

        while (!queue.isEmpty()) {
            List<Node> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                Node front = queue.removeFirst();
                if (front.row == rowCount - 1 && front.col == colCount - 1) {
                    return ans;
                }
                nodeList.add(front);
            }

            ans++;

            for (Node node : nodeList) {
                // 留下5个方向即可
                int row = node.row;
                int col = node.col;
                // 右上
                if (row > 0 && col < colCount - 1 && grid[row-1][col+1] == 0 && !visited[row-1][col+1]) {
                    queue.addLast(new Node(row-1, col+1));
                    visited[row-1][col+1] = true;
                }

                // 右
                if (col < colCount - 1 && grid[row][col+1] == 0 && !visited[row][col+1]) {
                    queue.addLast(new Node(row, col+1));
                    visited[row][col+1] = true;
                }

                //右下
                if (row < rowCount - 1 && col < colCount - 1 && grid[row+1][col+1] == 0 && !visited[row+1][col+1]) {
                    queue.addLast(new Node(row+1, col+1));
                    visited[row+1][col+1] = true;
                }

                // 下
                if (row < rowCount - 1 && grid[row+1][col] == 0 && !visited[row+1][col]) {
                    queue.addLast(new Node(row+1, col));
                    visited[row+1][col] = true;
                }

                // 左下
                if (row < rowCount - 1 && col > 0 && grid[row+1][col-1] == 0 && !visited[row+1][col-1]) {
                    queue.addLast(new Node(row+1, col-1));
                    visited[row+1][col-1] = true;
                }
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        
    }
    
}
