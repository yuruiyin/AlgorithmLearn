package problem301_400;

public class Problem348 {

    class TicTacToe {

        private int n;
        private char[][] grid;

        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            this.n = n;
            grid = new char[n][n];
        }

        private boolean isOver(char c, int row, int col) {
            // 列
            boolean isColOk = true;
            for (int i = 0; i < n; i++) {
                if (grid[i][col] != c) {
                    isColOk = false;
                    break;
                }
            }

            if (isColOk) {
                return true;
            }

            // 行
            boolean isRowOk = true;
            for (int j = 0; j < n; j++) {
                if (grid[row][j] != c) {
                    isRowOk = false;
                    break;
                }
            }

            if (isRowOk) {
                return true;
            }

            // 右对角线
            boolean isRightDiagonalOk = true;
            for (int i = 0; i < n; i++) {
                if (grid[i][i] != c) {
                    isRightDiagonalOk = false;
                    break;
                }
            }

            if (isRightDiagonalOk) {
                return true;
            }

            // 左对角线
            boolean isLeftDiagonalOk = true;
            for (int i = 0, j = n-1; i < n && j >= 0; i++, j--) {
                if (grid[i][j] != c) {
                    isLeftDiagonalOk = false;
                    break;
                }
            }

            return isLeftDiagonalOk;
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            char c = player == 1 ? 'X' : 'O';
            grid[row][col] = c;
            if (player == 1) {
                boolean canOver = isOver(c, row, col);
                return canOver ? 1 : 0;
            } else {
                boolean canOver = isOver(c, row, col);
                return canOver ? 2 : 0;
            }
        }
    }

}
