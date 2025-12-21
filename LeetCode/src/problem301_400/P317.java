package problem301_400;

import java.util.*;

public class P317 {

    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0,0, -1, 1};

    int ansMinDistance = Integer.MAX_VALUE;

    private int getDistanceSumByBfs(int[][] grid, int m, int n, int r, int c, int oneCount, boolean[][] visited) {
        LinkedList<int[]> queue = new LinkedList<>();
        int level = 0;
        int[] firstPos = new int[]{r, c};
        queue.add(firstPos);
        visited[r][c] = true;
        int distanceSum = 0;
        int reachOneCount = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curPos = queue.pollFirst();
                int curR = curPos[0];
                int curC = curPos[1];
                for (int j = 0; j < 4; j++) {
                    int nextR = curR + dx[j];
                    int nextC = curC + dy[j];
                    if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n) {
                        continue;
                    }
                    if (visited[nextR][nextC] || grid[nextR][nextC] == 2) {
                        continue;
                    }

                    int[] nextPos = new int[]{nextR, nextC};

                    int nextValue = grid[nextR][nextC];
                    visited[nextR][nextC] = true;
                    if (nextValue == 0) {
                        queue.add(nextPos);
                    } else {
                        distanceSum += level;
                        reachOneCount++;
                    }
                }
            }
        }

        if (oneCount == reachOneCount) {
            return distanceSum;
        }

        return -1;
    }

    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int oneCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    oneCount++;
                }
            }
        }

        boolean[][] unableReachPos = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (unableReachPos[i][j]) {
                        continue;
                    }
                    boolean[][] visited = new boolean[m][n];
                    int distanceSum = getDistanceSumByBfs(grid, m, n, i, j, oneCount, visited);
                    if (distanceSum == -1) {
                        // 不能达到
                        for (int ii = 0; ii < m; ii++) {
                            for (int jj = 0; jj < n; jj++) {
                                if (visited[ii][jj]) {
                                    unableReachPos[ii][jj] = true;
                                }
                            }
                        }
                    } else {
                        ansMinDistance = Math.min(ansMinDistance, distanceSum);
                    }
                }
            }
        }

        return ansMinDistance == Integer.MAX_VALUE ? -1 : ansMinDistance;
    }

    public static void main(String[] args) {
        System.out.println(new P317().shortestDistance(new int[][]{{1,0,2,0,1}, {0,0,0,0,0}, {0,0,1,0,0}}));
    }

}
