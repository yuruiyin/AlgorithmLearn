package problem201_300;

public class Problem286_2 {

    private int[][] rooms;
    private int rowCount;
    private int colCount;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private void dfs(int row, int col, int dis) {
        if (row < 0 || row >= rowCount || col < 0 || col >= colCount || dis >= rooms[row][col]) {
            return;
        }

        rooms[row][col] = dis;
        dfs(row - 1, col, dis + 1);
        dfs(row + 1, col, dis + 1);
        dfs(row, col - 1, dis + 1);
        dfs(row, col + 1, dis + 1);
    }

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        this.rooms = rooms;
        this.rowCount = rooms.length;
        this.colCount = rooms[0].length;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (rooms[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int nextRow = i + dx[k];
                        int nextCol = j + dy[k];
                        dfs(nextRow, nextCol, 1);
                    }
                }
            }
        }
    }

}
