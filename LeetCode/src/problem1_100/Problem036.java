package problem1_100;

public class Problem036 {

    private static final int SIZE = 9;

    public boolean isValidSudoku(char[][] board) {
        // 处理行
        for (int i = 0; i < SIZE; i++) {
            char[] flag = new char[SIZE + 1];
            for (int j = 0; j < SIZE; j++) {
                char c = board[i][j];
                 if (c == '.') {
                     continue;
                 }

                 if (flag[c - '0'] == '1') {
                     return false;
                 }

                 flag[c - '0'] = '1';
            }
        }

        // 处理列
        for (int j = 0; j < SIZE; j++) {
            char[] flag = new char[SIZE + 1];
            for (int i = 0; i < SIZE; i++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                if (flag[c - '0'] == '1') {
                    return false;
                }

                flag[c - '0'] = '1';
            }
        }

        // 处理9个九宫格
        for (int m = 0; m < SIZE; m += 3) { //i的偏移量
            for (int n = 0; n < SIZE; n += 3) {
                char[] flag = new char[SIZE + 1];
                for (int i = m; i < m + 3; i++) {
                    for (int j = n; j < n + 3; j++) {
                        char c = board[i][j];
                        if (c == '.') {
                            continue;
                        }

                        if (flag[c - '0'] == '1') {
                            return false;
                        }

                        flag[c - '0'] = '1';
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] borad1 = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(new Problem036().isValidSudoku(borad1));
    }
    
}
