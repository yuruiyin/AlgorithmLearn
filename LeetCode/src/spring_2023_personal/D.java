package spring_2023_personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class D {

    private int[][] dis;
    private char[][] grid;
    private int n;

    private int ansMin = Integer.MAX_VALUE;

    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private int[] mirror1(int[] node) {
        int x = node[0];
        int y = node[1];
        return new int[]{x, n - y - 1};
    }

    private int[] mirror2(int[] node) {
        int x = node[0];
        int y = node[1];
        return new int[]{n - x - 1, y};
    }

    private int bfs(int[] node) {
        int x = node[0];
        int y = node[1];
        if (grid[x][y] == '#') {
            return -1;
        }
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(node);
        boolean[][] visited = new boolean[n][n];
        visited[node[0]][node[1]] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                int curRow = tmp[0];
                int curCol = tmp[1];
                if (grid[curRow][curCol] == 'T') {
                    System.out.println(count);
                    return count;
                }
                for (int j = 0; j < 4; j++) {
                    int nextRow = curRow + dx[j];
                    int nextCol = curCol + dy[j];
                    if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n
                            || grid[nextRow][nextCol] == '#' || visited[nextRow][nextCol]) {
                        continue;
                    }
                    visited[nextRow][nextCol] = true;
                    queue.addLast(new int[]{nextRow, nextCol});
                }
            }
            count++;
        }
        return -1;
    }

    private int getMax(List<int[]> nodeList) {
        int max = -1;
        for (int i = 0; i < nodeList.size() - 1; i++) {
            int[] node = nodeList.get(i);
            int x = node[0];
            int y = node[1];
            if (dis[x][y] != -2) {
                max = Math.max(max, dis[x][y]);
                continue;
            }
            int[] m1 = mirror1(node);
            int[] m2 = mirror2(node);
            int tmpDis1 = bfs(m1);
            int tmpDis2 = bfs(m2);
            dis[x][y] = Math.max(tmpDis1, tmpDis2);
            max = Math.max(max, dis[x][y]);
        }
        return max;
    }

    private void dfs(int row, int col, boolean[][] visited, List<int[]> nodeList) {
        if (row < 0 || row >= n || col < 0 || col >= n || grid[row][col] == '#' || visited[row][col]) {
            return;
        }

        if (grid[row][col] == 'T') {
            // 到达水晶位置
            int value = getMax(nodeList);
            if (value == -1) {
                return;
            }
            ansMin = Math.min(ansMin, value);
            return;
        }

        visited[row][col] = true;

        for (int j = 0; j < 4; j++) {
            int nextRow = row + dx[j];
            int nextCol = col + dy[j];
            nodeList.add(new int[]{nextRow, nextCol});
            dfs(nextRow, nextCol, visited, nodeList);
            nodeList.remove(nodeList.size() - 1);
        }

        visited[row][col] = false;
    }

    private int[] getStartPos() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int challengeOfTheKeeper(String[] maze) {
        // bfs
        this.n = maze.length;
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = maze[i].toCharArray();
        }
        dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], -2);
        }

        int[] startPos = getStartPos();
        System.out.println(startPos[0] + ", " + startPos[1]);

        dfs(startPos[0], startPos[1], new boolean[n][n], new ArrayList<>());
        return ansMin == Integer.MAX_VALUE ? -1 : ansMin;
    }

}
