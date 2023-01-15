package contest.contest328;

public class B {

    // 差分
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        for (int[] update : updates) {
            int startIdx = update[0];
            int endIdx = update[1];
            int inc = update[2];
            diff[startIdx] += inc;
            if (endIdx < length - 1) {
                diff[endIdx + 1] -= inc;
            }
        }

        for (int i = 1; i < length; i++) {
            diff[i] += diff[i-1];
        }

        return diff;
    }

    public int[][] rangeAddQueries(int n, int[][] queries) {
//        int[][] resGrid = new int[n][n];
        int[][] rowDiff = new int[n][n];
        for (int[] q : queries) {
            int r1 = q[0];
            int c1 = q[1];
            int r2 = q[2];
            int c2 = q[3];
            for (int r = r1; r <= r2; r++) {
                rowDiff[r][c1]++;
                if (c2 < n - 1) {
                    rowDiff[r][c2 + 1]--;
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int i = 1; i < n; i++) {
                rowDiff[r][i] += rowDiff[r][i - 1];
            }
        }

        return rowDiff;
    }

}
