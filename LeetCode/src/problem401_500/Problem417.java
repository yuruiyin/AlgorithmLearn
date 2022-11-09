package problem401_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem417 {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] rowLeftArr = new boolean[m][n];
        boolean[][] rowRightArr = new boolean[m][n];
        boolean[][] colTopArr = new boolean[m][n];
        boolean[][] colBottomArr = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            rowLeftArr[i][0] = true;
            for (int j = 1; j < n; j++) {
                rowLeftArr[i][j] = rowLeftArr[i][j-1] && (heights[i][j] >= heights[i][j - 1]);
            }
            rowRightArr[i][n - 1] = true;
            for (int j = n - 2; j >= 0; j--) {
                rowRightArr[i][j] =  rowRightArr[i][j+1] && (heights[i][j] >= heights[i][j + 1]);
            }
        }

        for (int j = 0; j < n; j++) {
            colTopArr[0][j] = true;
            for (int i = 1; i < m; i++) {
                colTopArr[i][j] = colTopArr[i - 1][j] && (heights[i][j] >= heights[i - 1][j]);
            }
            colBottomArr[m - 1][j] = true;
            for (int i = m - 2; i >= 0; i--) {
                colBottomArr[i][j] = colBottomArr[i + 1][j] && (heights[i][j] >= heights[i + 1][j]);
            }
        }

        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int h = heights[i][j];
                if ((rowLeftArr[i][j] || colTopArr[i][j]) &&
                        (rowRightArr[i][j] || colBottomArr[i][j])) {
                    ansList.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return ansList;
    }

}
