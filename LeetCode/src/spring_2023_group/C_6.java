package spring_2023_group;

import java.util.ArrayList;
import java.util.List;

public class C_6 {

    class Node {
        int r;
        int c;
        int idx;
        Node(int r, int c, int idx) {
            this.r = r;
            this.c = c;
            this.idx = idx;
        }
    }

    // 使用ArrayList代替LinkedList
    public int extractMantra(String[] matrix, String mantra) {
        int m = matrix.length;
        int n = matrix[0].length();
        int len = mantra.length();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            grid[i] = matrix[i].toCharArray();
        }

        char[] arr = mantra.toCharArray();
        boolean[][][] visited = new boolean[m][n][len + 1];
        visited[0][0][0] = true;
        // r * 10000 + c * 100 + idx
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int ans = 0;
        int nowIdx = 0;
        while (nowIdx < list.size()) {
            int size = list.size();
            for (int i = nowIdx; i < size; i++) {
                int top = list.get(i);
                int idx = top % 100;
                if (idx == len) {
                    return ans;
                }
                int r = top / 10000;
                int c = top % 10000 / 100;
//                if (!visited[r][c][idx + 1] && matrix[r].charAt(c) == mantra.charAt(idx)) {
                if (grid[r][c] == arr[idx] && !visited[r][c][idx + 1]) {
                    list.add(r * 10000 + c * 100 + idx + 1);
                }
                for (int j = 0; j < 4; j++) {
                    int nextR = r + dx[j];
                    int nextC = c + dy[j];
                    if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || visited[nextR][nextC][idx]) {
                        continue;
                    }
                    visited[nextR][nextC][idx] = true;
                    list.add(nextR * 10000 + nextC * 100 + idx);
                }
            }
            ans++;
            nowIdx = size;
        }

        return -1;
    }

}
