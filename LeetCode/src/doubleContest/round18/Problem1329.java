package doubleContest.round18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1329 {

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int row = m - 1; row >= 0; row--) {
            List<Integer> list = new ArrayList<>();
            for (int i = row, j = 0; i < m && j < n; i++, j++) {
                list.add(mat[i][j]);
            }
            Collections.sort(list);
            int index = 0;
            for (int i = row, j = 0; i < m && j < n; i++, j++) {
                mat[i][j] = list.get(index++);
            }
        }

        for (int col = 1; col < n; col++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0, j = col; i < m && j < n; i++, j++) {
                list.add(mat[i][j]);
            }
            Collections.sort(list);
            int index = 0;
            for (int i = 0, j = col; i < m && j < n; i++, j++) {
                mat[i][j] = list.get(index++);
            }
        }

        return mat;
    }
    
    public static void main(String[] args) {
        int[][] ansArr = new Problem1329().diagonalSort(new int[][]{
                {3,3,1,1},
                {2,2,1,2},
                {1,1,1,2}
        });
    }

}
