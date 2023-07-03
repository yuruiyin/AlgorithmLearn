package spring_2023_group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class C {

    private Integer[][][] memo;
    private char[] arr;
    private List<int[]>[] posListArr;

    private int rec(int curIdx, int r, int c) {
        if (curIdx == arr.length) {
            return 0;
        }

        if (memo[curIdx][r][c] != null) {
            return memo[curIdx][r][c];
        }

        char curChar = arr[curIdx];
        List<int[]> posList = posListArr[curChar - 'a'];
        int resMin = Integer.MAX_VALUE;
        for (int[] pos : posList) {
            int res = rec(curIdx + 1, pos[0], pos[1]) + Math.abs(pos[0] - r) + Math.abs(pos[1] - c);
            resMin = Math.min(res, resMin);
        }

        return memo[curIdx][r][c] = resMin;
    }

    public int extractMantra(String[] matrix, String mantra) {
        posListArr = new ArrayList[26];
        Arrays.setAll(posListArr, value -> new ArrayList<>());
        int m = matrix.length;
        int n = matrix[0].length();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            grid[i] = matrix[i].toCharArray();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i][j];
                posListArr[c - 'a'].add(new int[]{i, j});
            }
        }

        arr = mantra.toCharArray();
        for (char c : arr) {
            if (posListArr[c - 'a'].isEmpty()) {
                return -1;
            }
        }
        memo = new Integer[101][101][101];
        return rec(0, 0, 0) + arr.length;
    }

}
