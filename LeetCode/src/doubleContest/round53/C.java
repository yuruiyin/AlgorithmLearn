package doubleContest.round53;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/29
 */
public class C {

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                set.add(grid[i][j]);
                if (set.size() > 3) {
                    set.pollLast();
                }
                for (int l = 1; i + l < m && i - l >= 0 && j + l < n && j - l >= 0; l++) {
                    int[] top = new int[]{i - l, j};
                    int[] right = new int[]{i, j + l};
                    int[] bottom = new int[]{i + l, j};
                    int[] left = new int[]{i, j - l};
                    int sum = 0;
                    for (int x = top[0], y = top[1]; x <= right[0] && y <= right[1]; x++, y++) {
                        sum += grid[x][y];
                    }

                    for (int x = right[0], y = right[1]; x <= bottom[0] && y >= bottom[1]; x++, y--) {
                        sum += grid[x][y];
                    }

                    for (int x = bottom[0], y = bottom[1]; x >= left[0] && y >= left[1]; x--, y--) {
                        sum += grid[x][y];
                    }

                    for (int x = left[0], y = left[1]; x >= top[0] && y <= top[1]; x--, y++) {
                        sum += grid[x][y];
                    }

                    sum -= grid[top[0]][top[1]];
                    sum -= grid[bottom[0]][bottom[1]];
                    sum -= grid[left[0]][left[1]];
                    sum -= grid[right[0]][right[1]];

                    set.add(sum);
                    if (set.size() > 3) {
                        set.pollLast();
                    }
                }
            }
        }

        int size = set.size();
        int[] ansArr = new int[size];
        int i = 0;
        while (!set.isEmpty()) {
            ansArr[i++] = set.pollLast();
        }

        int l = 0;
        int r = size - 1;
        while (l < r) {
            int t = ansArr[l];
            ansArr[l] = ansArr[r];
            ansArr[r] = t;
            l++;
            r--;
        }

        return ansArr;

    }

}
