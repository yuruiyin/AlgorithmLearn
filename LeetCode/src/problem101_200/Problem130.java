package problem101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem130 {

    private boolean[][] visited;
    private char[][] board;
    private int rowCount;
    private int colCount;

    private void bfs(int row, int col) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        List<int[]> queueNodeList = new ArrayList<>(); // 当前bfs中队列中所有‘O’的坐标列表

        boolean isSurrounded = true;

        while (!queue.isEmpty()) {
            List<int[]> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                int[] frontNode = queue.removeFirst();
                if (frontNode[0] == 0 || frontNode[0] == rowCount - 1 || frontNode[1] == 0 || frontNode[1] == colCount - 1) {
                    isSurrounded = false;
                }
                queueNodeList.add(frontNode);
                nodeList.add(frontNode);
            }

            for (int[] node : nodeList) {
                int i = node[0];
                int j = node[1];

                // 上
                if (i > 0 && board[i-1][j] == 'O' && !visited[i-1][j]) {
                    queue.add(new int[]{i-1, j});
                    visited[i-1][j] = true;
                }

                // 下
                if (i < rowCount - 1 && board[i+1][j] == 'O' && !visited[i+1][j]) {
                    queue.add(new int[]{i+1, j});
                    visited[i+1][j] = true;
                }

                // 左
                if (j > 0 && board[i][j-1] == 'O' && !visited[i][j-1]) {
                    queue.add(new int[]{i, j-1});
                    visited[i][j-1] = true;
                }

                // 右
                if (j < colCount - 1 && board[i][j+1] == 'O' && !visited[i][j+1]) {
                    queue.add(new int[]{i, j+1});
                    visited[i][j+1] = true;
                }
            }
        }

        // 所有的‘O’被'X'包围
        if (isSurrounded) {
            for (int[] queueNode: queueNodeList) {
                int i = queueNode[0];
                int j = queueNode[1];
                board[i][j] = 'X';
            }
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        this.board = board;
        this.rowCount = board.length;
        this.colCount = board[0].length;

        if (rowCount <= 2 || colCount <= 2) {
            return;
        }

        visited = new boolean[rowCount][colCount];
        for (int i = 1; i < rowCount - 1; i++) {
            for (int j = 1; j < colCount - 1; j++) {
                char c = board[i][j];
                if (c == 'X' || visited[i][j]) {
                    continue;
                }

                bfs(i, j);
            }
        }
    }

}
