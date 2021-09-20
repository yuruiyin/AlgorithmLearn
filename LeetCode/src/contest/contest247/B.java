package contest.contest247;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/27
 */
public class B {

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int min = Math.min(m / 2, n / 2);

        int[][] ansGrid = new int[m][n];
        for (int l = 0; l < min; l++) {
            List<int[]> posList = new ArrayList<>();
            for (int j = l; j < n - l - 1; j++) {
                posList.add(new int[]{l, j});
            }

            for (int i = l; i < m - l - 1; i++) {
                posList.add(new int[]{i, n - l - 1});
            }

            for (int j = n - l - 1; j > l; j--) {
                posList.add(new int[]{m - l - 1, j});
            }

            for (int i = m - l - 1; i > l; i--) {
                posList.add(new int[]{i, l});
            }

            int size = posList.size();
            int mod = k % size;
            int count = size - mod;
            while ((count--) > 0) {
                int[] prePos = Arrays.copyOf(posList.get(0), 2);
                posList.set(0, posList.get(size - 1));
                for (int r = 1; r < size; r++) {
                    int[] tmpPos = new int[]{posList.get(r)[0], posList.get(r)[1]};
                    posList.set(r, new int[]{prePos[0], prePos[1]});
                    prePos[0] = tmpPos[0];
                    prePos[1] = tmpPos[1];
                }
            }

            int index = 0;
            for (int j = l; j < n - l - 1; j++) {
                ansGrid[l][j] = grid[posList.get(index)[0]][posList.get(index)[1]];
                index++;
            }

            for (int i = l; i < m - l - 1; i++) {
                ansGrid[i][n - l - 1] = grid[posList.get(index)[0]][posList.get(index)[1]];
                index++;
            }

            for (int j = n - l - 1; j > l; j--) {
                ansGrid[m - l - 1][j] = grid[posList.get(index)[0]][posList.get(index)[1]];
                index++;
            }

            for (int i = m - l - 1; i > l; i--) {
                ansGrid[i][l] = grid[posList.get(index)[0]][posList.get(index)[1]];
                index++;
            }
        }

        return ansGrid;
    }

    public static void main(String[] args) {
        int[][] ans = new B().rotateGrid(new int[][]{
                {40, 10,}, {30, 20}
        }, 1);
    }

}
