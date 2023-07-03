package problem1001_1100;

import java.util.HashMap;
import java.util.Map;

public class Problem1072_1 {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;
        int ans = 0;
        Map<String, Integer> countMap = new HashMap<>();
        int size = n / 64 + 1;
        for (int[] row: matrix) {
            long[] r = new long[size];
            long first = row[0];
            for (int j = 0; j < n; j++) {
                r[j / 64] += (row[j] ^ first) << (j % 64);
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < size; j++) {
                sb.append(r[j]);
            }
            int cnt = countMap.merge(new String(sb), 1, Integer::sum);
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

}
