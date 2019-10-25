package problem001_100;

import java.util.ArrayList;
import java.util.List;

public class Problem037 {

    private static final int N = 9;

    // 预先计算每个空格可能的数字集合
    private ArrayList[] mayLegalNumList;

    private int[] getNextPos(int i, int j) {
        if (j == N - 1) {
            return new int[]{i + 1, 0};
        }

        return new int[]{i, j + 1};
    }

    /**
     * 获取当前位置合法的数字集合
     */
    private ArrayList<Character> getLegalNums(char[][] board, int row, int col) {
        boolean[] existArr = new boolean[10];
        // 判断行
        for (int j = 0; j < N; j++) {
            if (board[row][j] != '.') {
                existArr[board[row][j] - '0'] = true;
            }
        }

        // 判断列
        for (int i = 0; i < N; i++) {
            if (board[i][col] != '.') {
                existArr[board[i][col] - '0'] = true;
            }
        }

        // 判断九宫格
        int gridRow = row / 3;
        int gridCol = col / 3;
        int fromRowIndex = gridRow * 3;
        int fromColIndex = gridCol * 3;

        for (int i = fromRowIndex; i <= fromRowIndex + 2; i++) {
            for (int j = fromColIndex; j <= fromColIndex + 2; j++) {
                if (board[i][j] != '.') {
                    existArr[board[i][j] - '0'] = true;
                }
            }
        }

        ArrayList<Character> ansCharList = new ArrayList<>();
        for (char num = '1'; num <= '9'; num++) {
            if (!existArr[num - '0']) {
                ansCharList.add(num);
            }
        }

        return ansCharList;
    }

    private boolean isMatch(char[][] board, int row, int col, char value) {
        // 判断行
        for (int j = 0; j < N; j++) {
            if (board[row][j] == value) {
                return false;
            }
        }

        // 判断列
        for (int i = 0; i < N; i++) {
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
        if (i == N) {
            return true;
        }

        int[] nextPos = getNextPos(i, j);
        if (board[i][j] != '.') {
            return backTrack(board, nextPos[0], nextPos[1]);
        }

        List<Character> legalCharList = mayLegalNumList[i * N + j];

        boolean isFound;
        for (Character num: legalCharList) {
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
        mayLegalNumList = new ArrayList[N * N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') {
                    mayLegalNumList[i * N + j] = getLegalNums(board, i, j);
                }
            }
        }

        backTrack(board, 0, 0);
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

        new Problem037().solveSudoku(board);
    }
    
}
