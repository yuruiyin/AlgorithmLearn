package problem1001_1100;

import java.util.HashMap;
import java.util.Map;

public class Problem1072 {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;
        int ans = 0;
        Map<String, Integer> countMap = new HashMap<>();
        for (int[] row: matrix) {
            char[] r = new char[n];
            for (int j = 0; j < n; j++) {
                r[j] = (char) (row[j] ^ row[0]);
            }
            int cnt = countMap.merge(new String(r), 1, Integer::sum);
            if (cnt > ans) {
                ans = cnt;
            }
//            ans = Math.max(ans, cnt);
        }
        return ans;
    }

}
