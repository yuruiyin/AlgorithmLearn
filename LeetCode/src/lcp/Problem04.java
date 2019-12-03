package lcp;

public class Problem04 {

    private boolean[][] isBroken;
    private int rowCount;
    private int colCount;

    private int backTrack(int row, int col, boolean[][] visited) {
        if (row == rowCount || col == colCount || (row == rowCount - 1 && col == colCount - 1)) {
            return 0;
        }

        if (visited[row][col] || isBroken[row][col]) {
            if (col != colCount - 1) {
                return backTrack(row, col+1, visited);
            } else {
                return backTrack(row + 1, 0, visited);
            }
        }

        // 横着
        int rightCount = -1;
        if (col < colCount - 1 && !visited[row][col + 1] && !isBroken[row][col+1]) {
            visited[row][col] = true;
            visited[row][col+1] = true;
            if (col < colCount - 2) {
                rightCount = backTrack(row, col + 2, visited);
            } else {
                rightCount = backTrack(row+1, 0, visited);
            }

            visited[row][col] = false;
            visited[row][col+1] = false;
        }

        // 竖着
        int bottomCount = -1;
        if (row < rowCount - 1 && !visited[row+1][col] && !isBroken[row+1][col]) {
            visited[row][col] = true;
            visited[row+1][col] = true;
            if (col == colCount - 1) {
                bottomCount = backTrack(row+1, 0, visited);
            } else {
                bottomCount = backTrack(row, col+1, visited);
            }

            visited[row][col] = false;
            visited[row+1][col] = false;
        }

        if (rightCount == -1 && bottomCount == -1) {
            if (col != colCount - 1) {
                return backTrack(row, col+1, visited);
            } else {
                return backTrack(row + 1, 0, visited);
            }
        }

        return Math.max(rightCount, bottomCount) + 1;
    }

    public int domino(int n, int m, int[][] brokens) {
        this.rowCount = n;
        this.colCount = m;
        isBroken = new boolean[rowCount][colCount];

        for (int[] broken: brokens) {
            isBroken[broken[0]][broken[1]] = true;
        }

        return backTrack(0, 0, new boolean[rowCount][colCount]);
    }

    public static void main(String[] args) {
        System.out.println(new Problem04().domino(2, 3, new int[][]{
                {1,0}, {1,1}
        }));
    }

}
