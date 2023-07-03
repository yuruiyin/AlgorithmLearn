package doubleContest.round106;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class D {

    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        // 存在全0的行就可以直接返回
        // 其他情况，如果存在一定是2行
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            boolean isOk = true;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                return new ArrayList<>(Collections.singleton(i));
            }
        }

        int[] rows = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] = (rows[i] << 1) + grid[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if ((rows[i] & rows[j]) == 0) {
                    List<Integer> ansList = new ArrayList<>();
                    ansList.add(i);
                    ansList.add(j);
                    return ansList;
                }
            }
        }

        return new ArrayList<>();
    }

}
