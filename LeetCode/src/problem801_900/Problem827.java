package problem801_900;

import java.util.*;

public class Problem827 {

    class Island {
        int num;
        int area;

        Island(int num, int area) {
            this.num = num;
            this.area = area;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Island island = (Island) o;
            return num == island.num && area == island.area;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, area);
        }
    }

    private int[][] grid;
    private int m;
    private int n;

    private final int[] dx = new int[]{-1, 1, 0, 0};
    private final int[] dy = new int[]{0, 0, -1, 1};

    private int bfs(int r, int c, Island[][] islands, int islandNum) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        int area = 0;
        List<int[]> nodeList = new ArrayList<>();
        islands[r][c] = new Island(islandNum, 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curNode = queue.poll();
                nodeList.add(curNode);
                int curR = curNode[0];
                int curC = curNode[1];
                area++;
                for (int j = 0; j < 4; j++) {
                    int nextR = curR + dx[j];
                    int nextC = curC + dy[j];
                    if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || grid[nextR][nextC] == 0 ||
                            islands[nextR][nextC] != null) {
                        continue;
                    }
                    queue.add(new int[]{nextR, nextC});
                    islands[nextR][nextC] = new Island(islandNum, 0);
                }
            }
        }

        for (int[] node : nodeList) {
            islands[node[0]][node[1]].area = area;
        }
        return area;
    }

    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        // 每个各自隶属的岛屿（从1开始编号）
        Island[][] islands = new Island[m][n];
        int islandNum = 0;
        int ansMaxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || islands[i][j] != null) {
                    continue;
                }
                islandNum++;
                int area = bfs(i, j, islands, islandNum);
                ansMaxArea = Math.max(ansMaxArea, area);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                // 将0变成1
                Set<Island> islandSet = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int nextR = i + dx[k];
                    int nextC = j + dy[k];
                    if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || grid[nextR][nextC] == 0) {
                        continue;
                    }
                    islandSet.add(islands[nextR][nextC]);
                }
                int areaSum = 0;
                for (Island island : islandSet) {
                    areaSum += island.area;
                }
                ansMaxArea = Math.max(ansMaxArea, areaSum + 1);
            }
        }

        return ansMaxArea;
    }

    public static void main(String[] args) {
//        System.out.println(new Problem827().largestIsland(new int[][]{
//                {1, 1}, {1, 0}
//        }));
        System.out.println(new Problem827().largestIsland(new int[][]{
                {1, 1}, {1, 1}
        }));

    }

}
