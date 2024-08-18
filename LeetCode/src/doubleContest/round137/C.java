package doubleContest.round137;

public class C {

    public long maximumValueSum(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int max = (int) -1e9;
        int maxI = -1;
        int maxJ = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] >= max) {
                    max = board[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        int ansMax = (int) -3e9;
        for (int i = 0; i < m; i++) {
            if (i == maxI) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (j == maxJ) {
                    continue;
                }

                for (int k = 0; k < m; k++) {
                    if (k == maxI || k == i) {
                        continue;
                    }
                    for (int l = 0; l < n; l++) {
                        if (l == maxJ || l == j) {
                            continue;
                        }

                        ansMax = Math.max(ansMax, max + board[i][j] + board[k][l]);
                    }
                }
            }
        }

        return ansMax;
    }

}
