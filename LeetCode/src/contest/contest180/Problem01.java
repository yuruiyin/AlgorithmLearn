package contest.contest180;

import java.util.ArrayList;
import java.util.List;

public class Problem01 {

    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minIndex = j;
                }
            }

            int max = 0;
            int maxIndex = -1;
            for (int k = 0; k < m; k++) {
                if (matrix[k][minIndex] > max) {
                    max = matrix[k][minIndex];
                    maxIndex = k;
                }
            }

            if (maxIndex == i) {
                list.add(min);
            }
        }

        return list;
    }

}
