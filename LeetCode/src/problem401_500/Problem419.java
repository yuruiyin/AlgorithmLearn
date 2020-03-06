package problem401_500;

public class Problem419 {

    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }

        int m = board.length;
        int n = board[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (i > 0 && board[i-1][j] == 'X' || j > 0 && board[i][j-1] == 'X') {
                    continue;
                }

                ans++;
            }
        }

        return ans;
    }

}
