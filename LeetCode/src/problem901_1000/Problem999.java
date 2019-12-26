package problem901_1000;

public class Problem999 {

    private int[] getRPos(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{0, 0};
    }

    public int numRookCaptures(char[][] board) {
        int[] rPos = getRPos(board);
        int row = rPos[0];
        int col = rPos[1];
        int ansCount = 0;

        // 左
        for (int j = col - 1; j >= 0; j--) {
            if (board[row][j] == 'B') {
                break;
            }

            if (board[row][j] == 'p') {
                ansCount++;
                break;
            }
        }

        // 右
        for (int j = col + 1; j < 8; j++) {
            if (board[row][j] == 'B') {
                break;
            }

            if (board[row][j] == 'p') {
                ansCount++;
                break;
            }
        }

        // 上
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'B') {
                break;
            }

            if (board[i][col] == 'p') {
                ansCount++;
                break;
            }
        }

        // 下
        for (int i = row + 1; i < 8; i++) {
            if (board[i][col] == 'B') {
                break;
            }

            if (board[i][col] == 'p') {
                ansCount++;
                break;
            }
        }

        return ansCount;
    }

}
