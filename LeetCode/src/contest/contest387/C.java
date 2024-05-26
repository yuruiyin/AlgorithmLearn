package contest.contest387;

public class C {

    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int midX = n / 2;
        int midY = n / 2;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int count1 = 0;
            for (int k = 0; k < midX; k++) {
                if (grid[k][k] != i) {
                    count1++;
                }
                if (grid[k][n - k -1] != i) {
                    count1++;
                }
            }
            if (grid[midX][midX] != i) {
                count1++;
            }
            for (int k = midX + 1; k < n; k++) {
                if (grid[k][midY] != i) {
                    count1++;
                }
            }
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                int count2 = 0;
                for (int ii = 0; ii < n; ii++) {
                    for (int jj = 0; jj < n; jj++) {
                        if (ii <= midX && (ii == jj || ii + jj == n - 1) || ii > midX && jj == midY) {
                            continue;
                        }
                        if (grid[ii][jj] != j) {
                            count2++;
                        }
                    }
                }
                minCount = Math.min(minCount, count1 + count2);
            }
        }
        return minCount;
    }

}
