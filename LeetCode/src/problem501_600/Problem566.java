package problem501_600;

public class Problem566 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c || (m == r && n == c)) {
            return mat;
        }

        int[][] resMat = new int[r][c];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                resMat[idx / c][idx % c] = mat[i][j];
            }
        }
        return resMat;
    }

}
