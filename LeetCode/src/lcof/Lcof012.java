package lcof;

public class Lcof012 {

    private char[][] board;
    private char[] wordArr;
    private int m;
    private int n;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private boolean backTrack(int wordIdx, int row, int col, boolean[][] visited) {
        if (wordIdx == wordArr.length) {
            return true;
        }

        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || board[row][col] != wordArr[wordIdx]) {
            return false;
        }

        visited[row][col] = true;
        boolean isFound = false;
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            isFound = backTrack(wordIdx + 1, nextRow, nextCol, visited);
            if (isFound) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        wordArr = word.toCharArray();
        char firstChar = wordArr[0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == firstChar) {
                    boolean isFound = backTrack(0, i, j, new boolean[m][n]);
                    if (isFound) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
