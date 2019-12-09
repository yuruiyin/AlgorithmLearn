package problem201_300;

public class Problem289 {

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int rowCount = board.length;
        int colCount = board[0].length;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int oneCount = 0; // 八个相邻位置上1的个数
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if (k == 0 && l == 0) {
                            continue;
                        }

                        int row = i + k;
                        int col = j + l;
                        if (row < 0 || row >= rowCount || col < 0 || col >= colCount) {
                            continue;
                        }

                        if (board[row][col] == 1 || board[row][col] == 2) { // 2是从1变成0的临时状态
                            oneCount++;
                        }

                        if (oneCount > 3) {
                            break;
                        }
                    }
                }

                if (board[i][j] == 1) {
                    // 当前是活细胞
                    if (oneCount < 2 || oneCount > 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (oneCount == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                board[i][j] %= 2;
            }
        }
    }

}
