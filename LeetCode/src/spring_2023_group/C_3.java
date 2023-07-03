package spring_2023_group;

import java.util.Arrays;
import java.util.LinkedList;

public class C_3 {

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
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int ans = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Node top = queue.pollFirst();
                int idx = top.idx;
                if (idx == len) {
                    return ans;
                }
                int r = top.r;
                int c = top.c;
                if (grid[r][c] == arr[idx]) {
                    queue.addLast(new Node(r, c, idx + 1));
                }
                for (int j = 0; j < 4; j++) {
                    int nextR = r + dx[j];
                    int nextC = c + dy[j];
                    if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || visited[nextR][nextC][idx]) {
                        continue;
                    }
                    visited[nextR][nextC][idx] = true;
                    queue.addLast(new Node(nextR, nextC, idx));
                }
            }
            ans++;
        }

        return -1;
    }

}
