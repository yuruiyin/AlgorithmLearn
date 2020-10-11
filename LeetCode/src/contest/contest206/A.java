package contest.contest206;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/13
 */
public class A {

    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }

                boolean curRowAllZero = true;
                for (int jj = 0; jj < n; jj++) {
                    if (jj == j) {
                        continue;
                    }

                    if (mat[i][jj] == 1) {
                        curRowAllZero = false;
                        break;
                    }
                }

                if (!curRowAllZero) {
                    continue;
                }

                boolean curColAllZero = true;
                for (int ii = 0; ii < m; ii++) {
                    if (ii == i) {
                        continue;
                    }

                    if (mat[ii][j] == 1) {
                        curColAllZero = false;
                        break;
                    }
                }

                if (curColAllZero) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
