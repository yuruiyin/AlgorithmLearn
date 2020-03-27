package lcci;

/**
 * Lcci1604
 *
 * @author: yry
 * @date: 2020/3/27
 */
public class Lcci1604 {

    public String tictactoe(String[] board) {
        int n = board.length;
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = board[i].toCharArray();
        }

        // 行
        for (int i = 0; i < n; i++) {
            int oCount = 0;
            int xCount = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'O') {
                    oCount++;
                } else if (grid[i][j] == 'X') {
                    xCount++;
                }
            }

            if (xCount == n) {
                return "X";
            } else if (oCount == n) {
                return "O";
            }
        }

        // 列
        for (int j = 0; j < n; j++) {
            int oCount = 0;
            int xCount = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 'O') {
                    oCount++;
                } else if (grid[i][j] == 'X') {
                    xCount++;
                }
            }

            if (xCount == n) {
                return "X";
            } else if (oCount == n) {
                return "O";
            }
        }

        // 对角线1
        int oCount = 0;
        int xCount = 0;
        for (int i = 0; i < n; i++) {
            if (grid[i][i] == 'O') {
                oCount++;
            } else if (grid[i][i] == 'X') {
                xCount++;
            }
        }

        if (xCount == n) {
            return "X";
        } else if (oCount == n) {
            return "O";
        }

        // 对角线2
        oCount = 0;
        xCount = 0;
        for (int i = 0; i < n; i++) {
            if (grid[i][n - i - 1] == 'O') {
                oCount++;
            } else if (grid[i][n - i - 1] == 'X')  {
                xCount++;
            }
        }

        if (xCount == n) {
            return "X";
        } else if (oCount == n) {
            return "O";
        }

        // 判断是否已结束
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == ' ') {
                    return "Pending";
                }
            }
        }

        return "Draw";
    }

}
