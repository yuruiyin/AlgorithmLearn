package doubleContest.round59;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/8/21
 */
public class B {


    class Data {
        int i, j;
        int value;
        Data(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }

    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        List<Data> negativeDatas = new ArrayList<>();
        boolean hasZero = false;
        int minAbs = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) {
                    negativeDatas.add(new Data(i, j, matrix[i][j]));
                }

                if (matrix[i][j] == 0) {
                    hasZero = true;
                }
                sum += Math.abs(matrix[i][j]);
                
                minAbs = Math.min(minAbs, Math.abs(matrix[i][j]));
            }
        }

        if (hasZero) {
            return sum;
        }

        int negativeSize = negativeDatas.size();
        if (negativeSize % 2 == 0) {
            return sum;
        }

        return sum - 2 * minAbs;
    }
    

}
