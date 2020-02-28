package lcci;

public class Lcci0107 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int minIndex = 0;
        int maxIndex = n - 1;

        while (minIndex < maxIndex) {
            for (int j = minIndex; j < maxIndex; j++) {
                int tmp1 = matrix[j][maxIndex];
                matrix[j][maxIndex] = matrix[minIndex][j];
                int tmp2 = matrix[maxIndex][maxIndex - (j - minIndex)];
                matrix[maxIndex][maxIndex - (j - minIndex)] = tmp1;
                int tmp3 = matrix[maxIndex - (j - minIndex)][minIndex];
                matrix[maxIndex - (j - minIndex)][minIndex] = tmp2;
                matrix[minIndex][j] = tmp3;
            }
            minIndex++;
            maxIndex--;
        }
    }

}
