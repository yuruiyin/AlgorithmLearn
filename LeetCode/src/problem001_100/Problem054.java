package problem001_100;

import java.util.ArrayList;
import java.util.List;

public class Problem054 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int minLeft = 0;
        int maxRight = n - 1;
        int minTop = 0;
        int maxBottom = m - 1;

        List<Integer> ansList = new ArrayList<>();

        int direction = 0; // 0-从左往右 1-从上到下，2-从右往左，3从下到上

        while (ansList.size() < m * n) {
            if (direction == 0) {
                for (int j = minLeft; j <= maxRight; j++) {
                    ansList.add(matrix[minTop][j]);
                }
                direction = 1;
                minTop++;
            } else if (direction == 1) {
                for (int i = minTop; i <= maxBottom; i++) {
                    ansList.add(matrix[i][maxRight]);
                }
                direction = 2;
                maxRight--;
            } else if (direction == 2) {
                for (int j = maxRight; j >= minLeft; j--) {
                    ansList.add(matrix[maxBottom][j]);
                }
                direction = 3;
                maxBottom--;
            } else {
                for (int i = maxBottom; i >= minTop; i--) {
                    ansList.add(matrix[i][minLeft]);
                }
                direction = 0;
                minLeft++;
            }
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        List<Integer> ansList = new Problem054().spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        for (Integer num: ansList) {
            System.out.print(num + ",");
        }
        System.out.println();

        List<Integer> ansList1 = new Problem054().spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });

        for (Integer num: ansList1) {
            System.out.print(num + ",");
        }
        System.out.println();
    }
    
}
