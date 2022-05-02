package doubleContest.round77;

import java.util.*;

public class D {

    private int[][] grid;
    private int rowCount;
    private int colCount;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private boolean dfs(int r, int c, boolean[][] visited) {
        if (r < 0 || r >= rowCount || c < 0 || c >= colCount || visited[r][c] || grid[r][c] != 0) {
            return false;
        }

        if (r == rowCount - 1 && c == colCount - 1) {
            return true;
        }

        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nextR = r + dx[i];
            int nextC = c + dy[i];
            if (dfs(nextR, nextC, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean isFireOk(int r, int c, LinkedList<int[]> fireQueue, int[][] tmpGrid) {
        // 火扩散一次
        int size = fireQueue.size();
        for (int i = 0; i < size; i++) {
            int[] node = fireQueue.pollFirst();
            int curRow = node[0];
            int curCol = node[1];
            for (int j = 0; j < 4; j++) {
                int nextRow = curRow + dx[j];
                int nextCol = curCol + dy[j];
                if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount ||
                        tmpGrid[nextRow][nextCol] != 0) {
                    continue;
                }

                if (nextRow == r && nextCol == c || nextRow == rowCount - 1 && nextCol == colCount - 1) {
                    return false;
                }

                tmpGrid[nextRow][nextCol] = 1;
                fireQueue.add(new int[]{nextRow, nextCol});
            }
        }
        return true;
    }

    private boolean dfs(int r, int c, boolean[][] visited, int[][] tmpGrid, LinkedList<int[]> fireQueue) {
        if (r < 0 || r >= rowCount || c < 0 || c >= colCount || visited[r][c] || tmpGrid[r][c] != 0) {
            return false;
        }

        if (r == rowCount - 1 && c == colCount - 1) {
            return true;
        }

        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nextR = r + dx[i];
            int nextC = c + dy[i];
            if (nextR == rowCount - 1 && nextC == colCount - 1) {
                return true;
            }

            if (!isFireOk(nextR, nextC, fireQueue, tmpGrid)) {
                continue;
            }

            if (dfs(nextR, nextC, visited, tmpGrid, fireQueue)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOk(int stayTime) {
        // 停留stayTime分钟
        LinkedList<int[]> fireQueue = new LinkedList<>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1) {
                    fireQueue.add(new int[]{i, j});
                }
            }
        }

        int[][] tmpGrid = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                tmpGrid[i][j] = grid[i][j];
            }
        }

        int time = 0;
        boolean isOk = false;
        while (!fireQueue.isEmpty()) {
            if (time >= stayTime) {
                // 等完了，人也要开始走了
                isOk = true;
                break;
            }
            int size = fireQueue.size();
            for (int i = 0; i < size; i++) {
                int[] node = fireQueue.pollFirst();
                int curRow = node[0];
                int curCol = node[1];
                for (int j = 0; j < 4; j++) {
                    int nextRow = curRow + dx[j];
                    int nextCol = curCol + dy[j];
                    if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount ||
                            tmpGrid[nextRow][nextCol] != 0) {
                        continue;
                    }

                    if (nextRow == 0 && nextCol == 0 || nextRow == rowCount - 1 && nextCol == colCount - 1) {
                        return false;
                    }

                    tmpGrid[nextRow][nextCol] = 1;
                    fireQueue.add(new int[]{nextRow, nextCol});
                }
            }
            time++;
        }

        if (!isOk) {
            return false;
        }

        //  等完了，人也要开始走了
        return dfs(0, 0, new boolean[rowCount][colCount], tmpGrid, fireQueue);
    }

    public int maximumMinutes(int[][] grid) {
        // 先判断人到安全屋是不是通的
        this.grid = grid;
        this.rowCount = grid.length;
        this.colCount = grid[0].length;
        boolean isConnected = dfs(0, 0, new boolean[rowCount][colCount]);
        if (!isConnected) {
            return -1;
        }

        int l = 0;
        int r = 20000;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (isOk(mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (ans == -1) {
            return ans;
        }

        if (ans == 20000) {
            return (int) 1e9;
        }

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new D().maximumMinutes(new int[][]{
//                {0,2,0,0,0,0,0},{0,0,0,2,2,1,0},{0,2,0,0,1,2,0},{0,0,2,2,2,0,2},{0,0,0,0,0,0,0}
//        }));

        System.out.println(new D().maximumMinutes(new int[][]{
                {0,0,0,0},{0,1,2,0},{0,2,0,0}
        }));
    }

}
