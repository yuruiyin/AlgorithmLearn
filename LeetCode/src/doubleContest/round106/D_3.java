package doubleContest.round106;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class D_3 {

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

        long count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                boolean isOk = true;
                for (int k = 0; k < n; k++) {
                    count++;
                    if (grid[i][k] + grid[j][k] > 1) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    List<Integer> ansList = new ArrayList<>();
                    ansList.add(i);
                    ansList.add(j);
                    return ansList;
                }
            }
        }

        System.out.println("count: " + count);

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[][] grid = new int[10000][5];
        for (int i = 0; i < 10000; i++) {
            Arrays.fill(grid[i], 1);
        }

        long start = System.currentTimeMillis();
        new D_3().goodSubsetofBinaryMatrix(grid);
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + "ms");
    }

}
