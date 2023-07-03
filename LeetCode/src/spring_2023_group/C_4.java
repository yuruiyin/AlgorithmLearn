package spring_2023_group;

import java.util.LinkedList;

public class C_4 {

    // 不定义Node class
    public int extractMantra(String[] matrix, String mantra) {
        int m = matrix.length;
        int n = matrix[0].length();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            grid[i] = matrix[i].toCharArray();
        }

        char[] arr = mantra.toCharArray();
        int len = arr.length;
        boolean[][][] visited = new boolean[m + 1][n + 1][len + 1];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int ans = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] top = queue.pollFirst();
                int idx = top[2];
                if (idx == len) {
                    return ans;
                }
                int r = top[0];
                int c = top[1];
                if (grid[r][c] == arr[idx]) {
                    queue.addLast(new int[]{r, c, idx + 1});
                }
                for (int j = 0; j < 4; j++) {
                    int nextR = r + dx[j];
                    int nextC = c + dy[j];
                    if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || visited[nextR][nextC][idx]) {
                        continue;
                    }
                    visited[nextR][nextC][idx] = true;
                    queue.addLast(new int[]{nextR, nextC, idx});
                }
            }
            ans++;
        }

        return -1;
    }

}
