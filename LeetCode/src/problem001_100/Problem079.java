package problem001_100;

public class Problem079 {

    private boolean backTrack(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if(index == word.length()) {
            return true;
        }

        int rowCount = board.length;
        int colCount = board[0].length;

        // 上
        if (i > 0 && !visited[i-1][j] && board[i-1][j] == word.charAt(index)) {
            visited[i-1][j] = true;
            boolean topIsFound = backTrack(board, i-1, j, word, index+1, visited);
            visited[i-1][j] = false;
            if (topIsFound) {
                return true;
            }
        }

        // 下
        if (i < rowCount - 1 && !visited[i+1][j] && board[i+1][j] == word.charAt(index)) {
            visited[i+1][j] = true;
            boolean bottomIsFound = backTrack(board, i+1, j, word, index+1, visited);
            visited[i+1][j] = false;
            if (bottomIsFound) {
                return true;
            }
        }

        // 左
        if (j > 0 && !visited[i][j-1] && board[i][j-1] == word.charAt(index)) {
            visited[i][j-1] = true;
            boolean leftIsFound = backTrack(board, i, j-1, word, index+1, visited);
            visited[i][j-1] = false;
            if (leftIsFound) {
                return true;
            }
        }

        // 右
        if (j < colCount - 1 && !visited[i][j+1] && board[i][j+1] == word.charAt(index)) {
            visited[i][j+1] = true;
            boolean rightIsFound = backTrack(board, i, j+1, word, index+1, visited);
            visited[i][j+1] = false;
            if (rightIsFound) {
                return true;
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word.isEmpty()) {
            return false;
        }

        int rowCount = board.length;
        int colCount = board[0].length;
        char firstChar = word.charAt(0);


        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (board[i][j] == firstChar) {
                    if (word.length() == 1) {
                        return true;
                    }

                    boolean[][] visited = new boolean[rowCount][colCount];
                    visited[i][j] = true;
                    boolean isFound = backTrack(board, i, j, word, 1, visited);
                    if (isFound) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem079().exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        }, "ABCCED"));

        System.out.println(new Problem079().exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        }, "SEE"));

        System.out.println(new Problem079().exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        }, "ABCB"));
    }

}
