package doubleContest.round106;

import java.util.*;

public class D_1 {

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

        int size = set.size();
        int[] rows = new int[size];
        int idx = 0;
        for (int num : set) {
            rows[idx++] = num;
        }

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((rows[i] & rows[j]) == 0) {
                    List<Integer> ansList = new ArrayList<>();
                    int idx1 = indexMap[rows[i]];
                    int idx2 = indexMap[rows[j]];
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
