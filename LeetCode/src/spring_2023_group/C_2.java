package spring_2023_group;

import java.util.*;

public class C_2 {

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
        int[][][] dp = new int[m + 1][n + 1][len + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        dp[0][0][0] = 0;

        // 堆优化的dijkstra
//        PriorityQueue<Node> heap = new PriorityQueue<>(new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return dp[o1.r][o1.c][o1.idx] - dp[o2.r][o2.c][o2.idx];
//            }
//        });

        LinkedList<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0, 0));
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int ans = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            int r = top.r;
            int c = top.c;
            int idx = top.idx;
            if (top.idx == len) {
                ans = Math.min(ans, dp[r][c][idx]);
                continue;
            }

            if (grid[r][c] == arr[idx]) {
                if (dp[r][c][idx] + 1 < dp[r][c][idx + 1]) {
                    dp[r][c][idx + 1] = dp[r][c][idx] + 1;
                    queue.add(new Node(r, c, idx + 1));
                }
            }

            for (int i = 0; i < 4; i++) {
                int nextR = r + dx[i];
                int nextC = c + dy[i];
                if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n) {
                    continue;
                }
                if (dp[r][c][idx] + 1 < dp[nextR][nextC][idx]) {
                    dp[nextR][nextC][idx] = dp[r][c][idx] + 1;
                    queue.add(new Node(nextR, nextC, idx));
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
