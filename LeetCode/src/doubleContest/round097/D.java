package doubleContest.round097;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D {

    private int count;

    private int rowCount;
    private int colCount;

    private int[][] grid;

    private Set<Integer> path;

    private void dfs(int r, int c, boolean[][] visited, Set<Integer> visitedSet) {
        if (r < 0 || r >= rowCount || c < 0 || c >= colCount || grid[r][c] == 0 || visitedSet.contains(r * 1001 + c)) {
            return;
        }

        if (r == rowCount - 1 && c == colCount - 1) {
            if (path == null) {
                path = new HashSet<>();
                count = 1;
                path.addAll(visitedSet);
            } else {
                boolean isFound = false;
                for (int num : visitedSet) {
                    if (num == (rowCount - 1) * 1001 + colCount - 1) {
                        continue;
                    }
                    if (path.contains(num)) {
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    throw new RuntimeException();
                }
            }
            return;
        }

        visited[r][c] = true;

        visitedSet.add((r + 1) * 1001 + c);
        dfs(r + 1, c, visited, visitedSet);
        visitedSet.remove((r + 1) * 1001 + c);
        visitedSet.add(r * 1001 + c + 1);
        dfs(r, c + 1, visited, visitedSet);
        visitedSet.remove(r * 1001 + c + 1);
    }

    public boolean isPossibleToCutPath(int[][] grid) {
        // 计算有几条路径能到达终点即可，如果<=1,就是true
        this.count = 0;
        this.grid = grid;
        this.rowCount = grid.length;
        this.colCount = grid[0].length;

        if (rowCount == 1 && colCount == 2 || rowCount == 2 && colCount == 1) {
            return false;
        }

        try {
            dfs(0, 0, new boolean[rowCount][colCount], new HashSet<>());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new D().isPossibleToCutPath(new int[][]{
                {1,1,1},{1,0,1},{1,1,1}
        }));
    }

}
