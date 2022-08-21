package contest.contest304;

import java.util.HashMap;
import java.util.Map;

public class D_1 {

    private int ansMax = -1;
    private boolean[] visited;

    private void dfs(int cur, int[] edges, Map<Integer, Integer> disMap, int level) {
        int next = edges[cur];
        if (next == -1) {
            // 没有出边
            return;
        }

        if (visited[next]) {
            int dis = disMap.getOrDefault(next, -1);
            if (dis != -1 && level + 1 - dis > ansMax) {
                ansMax = level + 1 - dis;
            }
            return;
        }
        visited[next] = true;
        disMap.put(next, level + 1);
        dfs(next, edges, disMap, level + 1);
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (edges[i] == -1) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            Map<Integer, Integer> disMap = new HashMap<>();
            disMap.put(i, 0);
            dfs(i, edges, disMap, 0);
        }
        return ansMax;
    }

}
