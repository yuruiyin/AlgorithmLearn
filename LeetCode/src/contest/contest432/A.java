package contest.contest432;

import java.util.ArrayList;
import java.util.List;

public class A {

    public List<Integer> zigzagTraversal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> ansList = new ArrayList<>();
        int fromJ = 0;
        boolean leftToRight = true;
        for (int i = 0; i < m; i++) {
            if (leftToRight) {
                int j;
                for (j = fromJ; j < n; j += 2) {
                    ansList.add(grid[i][j]);
                }
                fromJ = j == n ? n - 1 : n - 2;
                leftToRight = false;
            } else {
                int j;
                for (j = fromJ; j >= 0; j -= 2) {
                    ansList.add(grid[i][j]);
                }
                fromJ = j == -1 ? 0 : 1;
                leftToRight = true;
            }
        }

        return ansList;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
