package contest.contest196;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/5
 */
public class C {

    public int numSubmat(int[][] mat) {
        int rowCount = mat.length;
        int colCount = mat[0].length;

        int[][] rowPreOneCountArr = new int[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            rowPreOneCountArr[i][0] = mat[i][0];
            for (int j = 1; j < colCount; j++) {
                if (mat[i][j] == 0) {
                    rowPreOneCountArr[i][j] = 0;
                } else {
                    rowPreOneCountArr[i][j] = rowPreOneCountArr[i][j-1] + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }

                int min = Integer.MAX_VALUE;
                for (int ii = i; ii >= 0 && mat[ii][j] > 0; ii--) {
                    min = Math.min(min, rowPreOneCountArr[ii][j]);
                    ans += min;
                }
            }
        }

        return ans;
    }

}
