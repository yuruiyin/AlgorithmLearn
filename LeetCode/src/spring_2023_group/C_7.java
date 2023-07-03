package spring_2023_group;

import java.util.Arrays;

public class C_7 {
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

    private static final Node[] nodeArr = new Node[1000000];

    private static final char[][] grid = new char[100][100];

    public int extractMantra(String[] matrix, String mantra) {
        int m = matrix.length;
        int n = matrix[0].length();
        int len = mantra.length();
        for (int i = 0; i < m; i++) {
            grid[i] = matrix[i].toCharArray();
        }

        char[] arr = mantra.toCharArray();
        int[][][] dis = new int[len + 1][m][n];
        int size = 0;
        nodeArr[size++] = new Node(0, 0, 0);
//        int[] dx = new int[]{-1, 1, 0, 0};
//        int[] dy = new int[]{0, 0, -1, 1};
        int nowIdx = 0;
        while (nowIdx < size) {
            Node top = nodeArr[nowIdx++];
            int idx = top.idx;
            int r = top.r;
            int c = top.c;
            int cur = dis[idx][r][c];
//            char curChar = matrix[r].charAt(c);
            char curChar = grid[r][c];
            while (idx < len && curChar == arr[idx]) {
                dis[idx + 1][r][c] = dis[idx][r][c];
                idx++;
            }
            if (idx == len) {
                return dis[idx][r][c] + len;
            }

//            for (int j = 0; j < 4; j++) {
//                int nextR = r + dx[j];
//                int nextC = c + dy[j];
//                if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || dis[idx][nextR][nextC] != 0) {
//                    continue;
//                }
//                dis[idx][nextR][nextC] = cur + 1;
//                nodeArr[size++] = new Node(nextR, nextC, idx);
//            }

            if (r - 1 >= 0 && dis[idx][r - 1][c] == 0) {
                dis[idx][r - 1][c] = cur + 1;
                nodeArr[size++] = new Node(r - 1, c, idx);
            }
            if (r + 1 < m && dis[idx][r + 1][c] == 0) {
                dis[idx][r + 1][c] = cur + 1;
                nodeArr[size++] = new Node(r + 1, c, idx);
            }
            if (c - 1 >= 0 && dis[idx][r][c - 1] == 0) {
                dis[idx][r][c - 1] = cur + 1;
                nodeArr[size++] = new Node(r, c - 1, idx);
            }
            if (c + 1 < n && dis[idx][r][c + 1] == 0) {
                dis[idx][r][c + 1] = cur + 1;
                nodeArr[size++] = new Node(r, c + 1, idx);
            }
        }

        return -1;
    }
}
