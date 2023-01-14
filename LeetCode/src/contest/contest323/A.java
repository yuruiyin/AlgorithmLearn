package contest.contest323;

import java.util.Arrays;
import java.util.Map;

public class A {

    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }

        int ans = 0;
        for (int j = n - 1; j >= 0; j--) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, grid[i][j]);
            }
            ans += max;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
