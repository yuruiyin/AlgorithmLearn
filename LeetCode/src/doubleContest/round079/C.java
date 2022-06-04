package doubleContest.round079;

import java.util.Arrays;

public class C {

    public long maximumImportance(int n, int[][] roads) {
        // 贪心
        long[] degree = new long[n];
        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
        }
        Arrays.sort(degree);
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans += (i + 1) * degree[i];
        }
        return ans;
    }

}
