package interview_bytedance.round08;

import java.util.HashMap;
import java.util.Map;

public class Problem03 {

    private Map<String, Integer> memo;
    private int[][] matrix;
    private int[][] rowBeforeSumMatrix;

    public Problem03(int[][] matrix) {
        this.matrix = matrix;
        memo = new HashMap<>();

        init();
    }

    private void init() {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        rowBeforeSumMatrix = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            rowBeforeSumMatrix[i][0] = matrix[i][0];
        }

        for (int i = 0; i < rowNum; i++) {
            for (int j = 1; j < colNum; j++) {
                rowBeforeSumMatrix[i][j] = matrix[i][j] + rowBeforeSumMatrix[i][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        String key = row1 + "," + col1 + "," + row2 + "," + col2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            int left = col1 == 0 ? 0 : rowBeforeSumMatrix[i][col1 - 1];
            int curRowSum = rowBeforeSumMatrix[i][col2] - left;
            sum += curRowSum;
        }

        memo.put(key, sum);

        return sum;
    }
    
    public static void main(String[] args) {
        Problem03 matrix = new Problem03(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });

        System.out.println(matrix.sumRegion(2, 1, 4, 3));
        System.out.println(matrix.sumRegion(2, 1, 4, 3));
    }
    
}
