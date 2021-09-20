package contest.contest254;

/**
 * A
 *
 * @author: yry
 * @date: 2021/8/15
 */
public class D {

    private boolean isOk(boolean[] visited) {
        for (boolean flag : visited) {
            if (!flag) {
                return true;
            }
        }
        return false;
    }

    private Boolean[][] memo;
    private int row;
    private int col;
    private int[][] grid;

    private boolean dfs(int i, int j, boolean[][] visited) {
        if (i == row) {
            return true;
        }

        if (j < 0 || j >= col || grid[i][j] == 1 || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (memo[i][j] != null && !memo[i][j]) {
            return memo[i][j];
        }

        boolean leftRes = dfs(i, j - 1, visited);
        boolean rightRes = dfs(i, j + 1, visited);
        boolean bottomRes = dfs(i + 1, j, visited);
        memo[i][j] = leftRes || rightRes || bottomRes;

        return memo[i][j];
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        boolean[] colVisited = new boolean[col];
        this.row = row;
        this.col = col;
        grid = new int[row][col];
        int ans = 0;
        memo = new Boolean[row][col];
        for (int i = 0; i < cells.length; i++) {
            int[] pos = cells[i];
            pos[0]--;
            pos[1]--;
            colVisited[pos[1]] = true;
            boolean hasColOk = isOk(colVisited);
            grid[pos[0]][pos[1]] = 1;
            if (hasColOk) {
                ans++;
                continue;
            }

            boolean isOk = false;
            for (int j = 0; j < col; j++) {
                boolean[][] visited = new boolean[row][col];
                isOk = dfs(0, j, visited);
                if (isOk) {
                    break;
                }
            }

            if (isOk) {
                ans++;
                continue;
            }

//            boolean[] tmpColVisited = new boolean[col];
//            for (int ii = pos[0] - 1; ii <= pos[0]; ii++) {
//                if (ii < 0) {
//                    continue;
//                }
//
//                for (int j = 0; j < col; j++) {
//                    if (grid[ii][j] == 1) {
//                        tmpColVisited[j] = true;
//                    }
//                }
//            }
//
//            tmpColVisited[pos[1]] = true;
//            boolean isOk1 = isOk(tmpColVisited);

//            LinkedList<int[]> queue = new LinkedList<>();
//
//
//            boolean[] tmpColVisited = new boolean[col];
//            for (int ii = pos[0] - 1; ii <= pos[0] + 1; ii++) {
//                if (ii < 0 || ii >= row) {
//                    continue;
//                }
//
//                for (int j = 0; j < col; j++) {
//                    if (grid[ii][j] == 1) {
//                        tmpColVisited[j] = true;
//                    }
//                }
//            }
//
//            tmpColVisited[pos[1]] = true;
//            boolean isOk = isOk(tmpColVisited);
//            if (isOk) {
//                ans++;
//                continue;
//            }

            break;
        }

        return ans;

    }

    public static void main(String[] args) {
//        System.out.println(new D().latestDayToCross(2, 2, new int[][]{
//                {1,1},{2,1},{1,2},{2,2}
//        }));

        System.out.println(new D().latestDayToCross(3, 3, new int[][]{
                {1, 2}, {2, 1}, {3, 3}, {2, 2}, {1, 1}, {1, 3}, {2, 3}, {3, 2}, {3, 1}
        }));

        System.out.println(new D().latestDayToCross(3, 4, new int[][]{
                {3,1},{2,3},{1,3},{3,2},{2,1},{1,4},{1,1},{2,4},{3,4},{1,2},{2,2},{3,3}
        }));
    }

}
