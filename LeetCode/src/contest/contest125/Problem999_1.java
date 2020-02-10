package contest.contest125;

public class Problem999_1 {

    private int[] getRockPos(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    return new int[]{i, j};
                }
            }
        }

        return new int[2];
    }

    public int numRookCaptures(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] rockPos = getRockPos(board);

        int rockRow = rockPos[0];
        int rockCol = rockPos[1];
        int ans = 0;

        // 上
        for (int i = rockRow - 1; i >= 0; i--) {
            if (board[i][rockCol] == 'B') {
                break;
            }

            if (board[i][rockCol] == 'p') {
                ans++;
                break;
            }
        }

        // 下
        for (int i = rockRow + 1; i < m; i++) {
            if (board[i][rockCol] == 'B') {
                break;
            }

            if (board[i][rockCol] == 'p') {
                ans++;
                break;
            }
        }

        for (int j = rockCol - 1; j >= 0; j--) {
            if (board[rockRow][j] == 'B') {
                break;
            }

            if (board[rockRow][j] == 'p') {
                ans++;
                break;
            }
        }

        for (int j = rockCol + 1; j < n; j++) {
            if (board[rockRow][j] == 'B') {
                break;
            }

            if (board[rockRow][j] == 'p') {
                ans++;
                break;
            }
        }

        return ans;
    }

}
