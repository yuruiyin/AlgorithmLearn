package problem901_1000;

import java.util.ArrayList;
import java.util.List;

public class Problem997 {

    public int findJudge(int n, int[][] trusts) {
        List<Integer>[] adj = new ArrayList[n + 1];

        for (int[] trust: trusts) {
            int a = trust[0];
            int b = trust[1];

            if (adj[a] == null) {
                adj[a] = new ArrayList<>();
            }

            adj[a].add(b);
        }

        int[] inDegree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (adj[i] == null) {
                continue;
            }
            for (Integer next: adj[i]) {
                inDegree[next]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1 && adj[i] == null) {
                return i;
            }
        }

        return -1;
    }

}
