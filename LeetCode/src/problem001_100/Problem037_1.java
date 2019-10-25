package problem001_100;

public class Problem037_1 {

    private static final int ROW_CNT = 9;
    private static final int COL_CNT = 9;

    private int[] getNextPos(int i, int j) {
        if (j == COL_CNT - 1) {
            return new int[]{i + 1, 0};
        }

        return new int[]{i, j + 1};
    }

    private boolean isMatch(char[][] board, int row, int col, char value) {
        // 判断行
        for (int j = 0; j < COL_CNT; j++) {
            if (board[row][j] == value) {
                return false;
            }
        }

        // 判断列
        for (int i = 0; i < ROW_CNT; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        // 判断九宫格
        int gridRow = row / 3;
        int gridCol = col / 3;
        int fromRowIndex = gridRow * 3;
        int fromColIndex = gridCol * 3;

        for (int i = fromRowIndex; i <= fromRowIndex + 2; i++) {
            for (int j = fromColIndex; j <= fromColIndex + 2; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean backTrack(char[][] board, int i, int j) {
        if (i == ROW_CNT) {
            return true;
        }

        int[] nextPos = getNextPos(i, j);
        if (board[i][j] != '.') {
            return backTrack(board, nextPos[0], nextPos[1]);
        }

        boolean isFound;
        for (char num = '1'; num <= '9'; num++) {
            if (!isMatch(board, i, j, num)) {
                continue;
            }

            // 往下走
            board[i][j] = num;
            isFound = backTrack(board, nextPos[0], nextPos[1]);
            if (isFound) {
                return true;
            }
            board[i][j] = '.';
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);
    }
    
    public static void main(String[] args) {

    }

}
