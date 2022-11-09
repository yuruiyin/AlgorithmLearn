package doubleContest.round086;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C {

    private int[][] mat;
    private int m;
    private int n;
    private int cols;

    private int ansMaxRows = 0;

    private void dfs(int col, Set<Integer> colSet) {
        if (colSet.size() == cols) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                boolean isOk = true;
                for (int j = 0; j < n;j ++) {
                    if (mat[i][j] == 1 && !colSet.contains(j)) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    count++;
                }
            }
            ansMaxRows = Math.max(ansMaxRows, count);
            return;
        }

        if (col == n) {
            return;
        }

        colSet.add(col);
        dfs(col + 1, colSet);
        colSet.remove(col);
        dfs(col + 1, colSet);
    }

    public int maximumRows(int[][] mat, int cols) {
        m = mat.length;
        n = mat[0].length;
        this.mat = mat;
        this.cols = cols;
        dfs(0, new HashSet<>());
        return ansMaxRows;
    }

}
