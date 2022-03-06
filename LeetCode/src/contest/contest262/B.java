package contest.contest262;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/10
 */
public class B {

    private int calcCount(int[][] grid, int target, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int ansCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(grid[i][j] - target) % x != 0) {
                    return -1;
                }
                ansCount += Math.abs(grid[i][j] - target) / x;
            }
        }
        return ansCount;
    }

    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                min = Math.min(min, grid[i][j]);
                max = Math.max(max, grid[i][j]);
            }
        }

        if (max == min) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i+=x) {
            list.add(i);
        }

        int size = list.size();

        int l = 0;
        int r = size - 1;

        if (size == 1) {
            return -1;
        }

        int ansCount = -1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int midVal = list.get(mid);
            int curCount = calcCount(grid, midVal, x);
            if (mid == 0) {
                if (calcCount(grid, list.get(mid + 1), x) > curCount) {
                    ansCount = curCount;
                    break;
                }

                l = mid + 1;
            } else if (mid == size - 1) {
                if (calcCount(grid, list.get(mid - 1), x) > curCount) {
                    ansCount = curCount;
                    break;
                }

                r = mid - 1;
            } else {
                int leftCount = calcCount(grid, list.get(mid - 1), x);
                int rightCount = calcCount(grid, list.get(mid + 1), x);
                if (leftCount > curCount &&  rightCount > curCount) {
                    ansCount = curCount;
                    break;
                } else if (leftCount > curCount) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        if (ansCount == -1) {
            ansCount = calcCount(grid, list.get(l), x);
        }

        return ansCount;
    }
    
    public static void main(String[] args) {
        System.out.println(new B().minOperations(new int[][]{
                {2, 4},{6,8}
        }, 2));
    }

}
