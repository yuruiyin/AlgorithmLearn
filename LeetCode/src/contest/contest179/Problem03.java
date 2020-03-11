package contest.contest179;

import java.util.ArrayList;
import java.util.List;

public class Problem03 {

    private List<Integer>[] adj;
    private int ansMax = 0;
    private int[] informTime;

    private void dfs(int idx, int sum) {
        if (adj[idx] == null) {
            ansMax = Math.max(ansMax, sum);
            return;
        }

        List<Integer> nextList = adj[idx];
        for (Integer next: nextList) {
            dfs(next, sum + informTime[idx]);
        }
    }

    public int numOfMinutes(int n, int headID, int[] managers, int[] informTime) {
        adj = new ArrayList[n];
        this.informTime = informTime;

        for (int i = 0; i < n; i++) {
            int manager = managers[i];
            if (manager == -1) {
                continue;
            }
            if (adj[manager] == null) {
                adj[manager] = new ArrayList<>();
            }
            adj[manager].add(i);
        }

        dfs(headID, 0);
        return ansMax;
    }

}
