package problem1201_1300;

public class Problem1284 {

    private int rowCount;
    private int colCount;

    private boolean isAllZero(int[][] mat) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (mat[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private void convert(int[][] mat, int i, int j) {
        mat[i][j] ^= 1;
        if (i > 0) {
            mat[i-1][j] ^= 1;
        }

        if (i < rowCount-1) {
            mat[i+1][j] ^= 1;
        }

        if (j > 0) {
            mat[i][j-1] ^= 1;
        }

        if (j < colCount - 1) {
            mat[i][j+1] ^= 1;
        }
    }

    private int backTrack(int[][] mat, boolean[][] visited) {
        if (isAllZero(mat)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (visited[i][j]) {
                    continue;
                }

                visited[i][j] = true;
                convert(mat, i, j);
                int res = backTrack(mat, visited);
                convert(mat, i, j);
                visited[i][j] = false;

                if (res == -1) {
                    continue;
                }

                int curCount = res + 1;
                if (curCount < min) {
                    min = curCount;
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int minFlips(int[][] mat) {
        rowCount = mat.length;
        colCount = mat[0].length;

        return backTrack(mat, new boolean[rowCount][colCount]);
    }
    
    public static void main(String[] args) {
        
    }
    
}
