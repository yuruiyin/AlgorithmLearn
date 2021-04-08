package spring_2021_personal;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/5
 */
public class D {

    private List<char[][]> gridList;
    private int rowCount;
    private int colCount;
//    private Boolean[][][][] dp;
    private int[] dx = new int[]{0, 0, 1, -1};
    private int[] dy = new int[]{1, -1, 0, 0};

    private void convert(List<List<String>> maze) {
        gridList = new ArrayList<>();
        for (List<String> list : maze) {
            char[][] grid = new char[list.size()][list.get(0).length()];
            for (int i = 0; i < list.size(); i++) {
                grid[i] = list.get(i).toCharArray();
            }
            gridList.add(grid);
        }
    }

    private boolean dfs(int preRow, int preCol, int row, int col, int t, int trapCount, boolean[][] visited) {
        if (row < 0 || row >= rowCount || col < 0 || col >= colCount || t >= gridList.size()
                || (trapCount == 1 && gridList.get(t)[row][col] == '#')) {
            return false;
        }

        if (row == rowCount - 1 && col == colCount - 1) {
            return true;
        }

        boolean isChange = false;
        if (gridList.get(t)[row][col] == '#') {
            gridList.get(t)[row][col] = '.';
            isChange = true;
            trapCount++;
        }

        // 包括停留在原地，往上下左右
        if (visited[row][col]) {
            visited[row][col] = true;
            if (preRow == row && preCol == col) {
                boolean resNotChange = dfs(row, col, row, col, t + 1, trapCount, visited);
                if (resNotChange) {
                    return true;
                }
            }
            if (isChange) {
                gridList.get(t)[row][col] = '#';
            }
            return false;
        }

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            boolean res = dfs(row, col, nextRow, nextCol, t + 1, trapCount, visited);
            if (res) {
                return true;
            }
        }
        if (isChange) {
            gridList.get(t)[row][col] = '#';
        }
        return false;
    }

    public boolean escapeMaze(List<List<String>> maze) {
        convert(maze);
        rowCount = gridList.get(0).length;
        colCount = gridList.get(0)[0].length;
        boolean isOk = false;
//        dp = new Boolean[51][51][101][2];
        List<char[][]> copyGridList = new ArrayList<>();
        for (char[][] grid : gridList) {
            char[][] copyGrid = new char[rowCount][colCount];
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    copyGrid[i][j] = grid[i][j];
                }
            }
            copyGridList.add(copyGrid);
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                for (char[][] grid : gridList) {
                    grid[i][j] = '.';
                }

                if (dfs(-1, -1, 0, 0, 0, 0, new boolean[rowCount][colCount])) {
                    return true;
                }

                for (int k = 0; k < gridList.size(); k++) {
                    gridList.get(k)[i][j] = copyGridList.get(k)[i][j];
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println("1");
        System.out.println(new D().escapeMaze(new ArrayList<>()));
    }

}
