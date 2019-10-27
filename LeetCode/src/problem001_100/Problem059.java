package problem001_100;

public class Problem059 {

    public int[][] generateMatrix(int n) {
        int[][] ansMatrix = new int[n][n];

        int minRow = 0;
        int maxRow = n-1;
        int minCol = 0;
        int maxCol = n-1;

        int count = 0;
        int matrixSize = n * n;

        while (count < matrixSize) {
            for (int j = minCol; j <= maxCol; j++) {
                ansMatrix[minRow][j] = ++count;
            }
            minRow++;

            for (int i = minRow; i <= maxRow; i++) {
                ansMatrix[i][maxCol] = ++count;
            }
            maxCol--;

            for (int j = maxCol; j >= minCol; j--) {
                ansMatrix[maxRow][j] = ++count;
            }
            maxRow--;

            for (int i = maxRow; i >= minRow; i--) {
                ansMatrix[i][minCol] = ++count;
            }
            minCol++;
        }

        return ansMatrix;
    }
    
    public static void main(String[] args) {

    }
    
}
