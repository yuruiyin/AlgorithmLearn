package problem001_100;

public class Problem048 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || n == 1) {
            return;
        }

        int minRowCol = 0;
        int maxRowCol = n - 1;

        while (minRowCol < maxRowCol) {
            for (int j = minRowCol; j < maxRowCol; j++) {
                int tmp1 = matrix[j][maxRowCol];
                matrix[j][maxRowCol] = matrix[minRowCol][j];
                int tmp2 = matrix[maxRowCol][maxRowCol - (j - minRowCol)];
                matrix[maxRowCol][maxRowCol - (j - minRowCol)] = tmp1;
                int tmp3 = matrix[maxRowCol - (j - minRowCol)][minRowCol];
                matrix[maxRowCol - (j - minRowCol)][minRowCol] = tmp2;
                matrix[minRowCol][j] = tmp3;
            }
            minRowCol++;
            maxRowCol--;
        }
    }
    
    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };

        int[][] matrix = new int[][]{
                {5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}
        };

        new Problem048().rotate(matrix);
        
        for (int[] nums: matrix) {
            for (int num: nums) {
                System.out.print(num + ",");
            }
            System.out.println();
        }


    }
    
}
