package contest.contest343;

import java.util.HashSet;
import java.util.Set;

public class B {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
//        Set<Integer> rowSet = new HashSet<>();
//        Set<Integer> colSet = new HashSet<>();
        int m = mat.length;
        int n = mat[0].length;
        int[] rowCountArr = new int[m];
        int[] colCountArr = new int[n];
        int[][] posArr = new int[m * n + 1][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                posArr[mat[i][j]] = new int[]{i, j};
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int[] pos = posArr[value];
            rowCountArr[pos[0]]++;
            colCountArr[pos[1]]++;
            if (rowCountArr[pos[0]] == n || colCountArr[pos[1]] == m) {
                return i;

            }
        }
        return -1;
    }

}
