package problem1101_1200;

public class Problem1102 {

    private int rowCount;
    private int colCount;

    private int backTrack(int[][] arr, int i, int j, boolean[][] visited) {
        if (i == rowCount - 1 && j == colCount - 1) {
            return arr[i][j];
        }

        // up
        int upMin = 0;
        if (i > 0 && !visited[i-1][j]) {
            visited[i-1][j] = true;
            upMin = backTrack(arr, i-1, j, visited);
            visited[i-1][j] = false;
        }

        // down
        int downMin = 0;
        if (i < rowCount - 1 && !visited[i+1][j]) {
            visited[i+1][j] = true;
            downMin = backTrack(arr, i+1, j, visited);
            visited[i+1][j] = false;
        }

        // left
        int leftMin = 0;
        if (j > 0 && !visited[i][j-1]) {
            visited[i][j-1] = true;
            leftMin = backTrack(arr, i, j-1, visited);
            visited[i][j-1] = false;
        }

        // right
        int rightMin = 0;
        if (j < colCount - 1 && !visited[i][j+1]) {
            visited[i][j+1] = true;
            rightMin = backTrack(arr, i, j+1, visited);
            visited[i][j+1] = false;
        }

        int tmpMax = Math.max(Math.max(upMin, downMin), Math.max(leftMin, rightMin));

        return Math.min(tmpMax, arr[i][j]);

    }

    public int maximumMinimumPath(int[][] arr) {
        int rowCount = arr.length;
        int colCount = arr[0].length;
        this.rowCount = rowCount;
        this.colCount = colCount;
        boolean[][] visited = new boolean[rowCount][colCount];
        visited[0][0] = true;

        int ans = backTrack(arr, 0, 0, visited);

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
    
    public static void main(String[] args) {

    }
    
}
