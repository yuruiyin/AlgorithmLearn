package doubleContest.round106;

import java.util.*;

public class D_2 {

    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        // 存在全0的行就可以直接返回
        // 其他情况，如果存在一定是2行
        int m = grid.length;
        int n = grid[0].length;
        Set<Integer> set = new HashSet<>();
        int[] indexMap = new int[1 << n];
        for (int i = 0; i < m; i++) {
            int row = 0;
            for (int j = 0; j < n; j++) {
                row = (row << 1) + grid[i][j];
            }
            if (row == 0) {
                return new ArrayList<>(Collections.singleton(i));
            }
            set.add(row);
            indexMap[row] = i;
        }

        int end = 1 << n;
        for (int i = 1; i < end; i++) {
            for (int j = 1; j < end; j++) {
                if ((i & j) == 0 && set.contains(i) && set.contains(j)) {
                    List<Integer> ansList = new ArrayList<>();
                    int idx1 = indexMap[i];
                    int idx2 = indexMap[j];
                    if (idx1 < idx2) {
                        ansList.add(idx1);
                        ansList.add(idx2);
                    } else {
                        ansList.add(idx2);
                        ansList.add(idx1);
                    }
                    return ansList;
                }
            }
        }

        return new ArrayList<>();
    }

}
