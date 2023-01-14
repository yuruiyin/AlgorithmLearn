package doubleContest.round092;

public class B {

    public int[][] onesMinusZeros(int[][] grid) {
        // diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
        int m = grid.length;
        int n = grid[0].length;
        int[][] diff = new int[m][n];
        int[] onesRow = new int[m];
        int[] onesCol = new int[n];
        int[] zerosRow = new int[m];
        int[] zerosCol = new int[n];
        for (int i = 0; i < m; i++) {
            int oneCount = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    oneCount++;
                }
            }
            onesRow[i] = oneCount;
            zerosRow[i] = n - oneCount;
        }

        for (int j = 0; j < n; j++) {
            int oneCount = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    oneCount++;
                }
            }
            onesCol[j] = oneCount;
            zerosCol[j] = m - oneCount;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }

        return diff;
    }

}
