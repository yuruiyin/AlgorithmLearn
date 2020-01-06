package contest.contest103;

import java.util.LinkedList;

public class Problem909 {

    private int[][] board;
    private int rowCount;
    private int colCount;

    private int bfs() {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[rowCount][colCount];

        visited[0][0] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int row = node[0];
                int col = node[1];

                if (row == rowCount - 1 && col == colCount - 1) {
                    return count;
                }

                for (int y = 1; y <= 6; y++) {
                    int nextRow = row + (col + y) / colCount;
                    int nextCol = (col + y) % colCount;
                    if (nextRow >= rowCount) {
                        continue;
                    }

                    int newNextRow = nextRow;
                    int newNextCol = nextCol;
                    if (board[nextRow][nextCol] != -1) {
                        newNextRow = (board[nextRow][nextCol] - 1) / colCount;
                        newNextCol = (board[nextRow][nextCol] - 1) % colCount;
                    }

                    if (visited[newNextRow][newNextCol]) {
                        continue;
                    }

                    visited[newNextRow][newNextCol] = true;
                    queue.add(new int[]{newNextRow, newNextCol});
                }
            }

            count++;
        }

        return -1;
    }

    public int snakesAndLadders(int[][] board) {
        rowCount = board.length;
        colCount = board[0].length;
        int[][] newBoard = new int[rowCount][colCount];

        for (int i = rowCount - 1; i >= 0; i--) {
            if ((rowCount - i) % 2 == 1) {
                // 从左往右
                for (int j = 0; j < colCount; j++) {
                    newBoard[rowCount - i - 1][j] = board[i][j];
                }
            } else {
                for (int j = 0; j < colCount; j++) {
                    newBoard[rowCount - i - 1][colCount - j - 1] = board[i][j];
                }
            }
        }

        this.board = newBoard;
        return bfs();
    }

    public static void main(String[] args) {
        System.out.println(new Problem909().snakesAndLadders(new int[][]{
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        }));
    }

}
