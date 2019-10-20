package problem301_400;

public class Problem329 {

    private int[][] visited;

    private int dfs(int[][] matrix, int m, int n, int i, int j) {
        if (visited[i][j] != 0) {
            return visited[i][j];
        }

        int leftMax = 0;
        if (j > 0 && matrix[i][j-1] > matrix[i][j]) {
            leftMax = dfs(matrix, m, n, i, j-1);
        }

        int topMax = 0;
        if (i > 0 && matrix[i-1][j] > matrix[i][j]) {
            topMax = dfs(matrix, m, n, i-1, j);
        }

        int rightMax = 0;
        if (j < n-1 && matrix[i][j+1] > matrix[i][j]) {
            rightMax = dfs(matrix, m, n, i, j+1);
        }

        int bottomMax = 0;
        if (i < m-1 && matrix[i+1][j] > matrix[i][j]) {
            bottomMax = dfs(matrix, m, n,i+1, j);
        }

        int leftRightMax = Math.max(leftMax, rightMax);
        int topBottomMax = Math.max(topMax, bottomMax);
        int max = Math.max(leftRightMax, topBottomMax) + 1;
        visited[i][j] = max;
        return max;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix[0].length;

        int maxPathLen = 1;
        visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] != 0) {
                    continue;
                }
                int tmpMax = dfs(matrix, m, n, i, j);
                if (tmpMax > maxPathLen) {
                    maxPathLen = tmpMax;
                }
            }
        }

        return maxPathLen;
    }

    public static void main(String[] args) {
        System.out.println(new Problem329().longestIncreasingPath(new int[][]{
                {9,9,4},
                {6,6,8},
                {2,1,1}
        }));

        System.out.println(new Problem329().longestIncreasingPath(new int[][]{
                {3,4,5},
                {3,2,6},
                {2,2,1}
        }));

//        [[1,4,7,9],[0,3,8,5],[3,6,0,6],[1,4,5,6]]
        System.out.println(new Problem329().longestIncreasingPath(new int[][]{
                {1,4,7,9},
                {0,3,8,5},
                {3,6,0,6},
                {1,4,5,6}
        }));
    }
    
}
