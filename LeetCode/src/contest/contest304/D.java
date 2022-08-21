package contest.contest304;

import java.util.*;

public class D {

    class Solution {
        private int ansMax = -1;
        private boolean[] visited;

        private void dfs(int cur, List<Integer>[] adj, Map<Integer, Integer> disMap, int level) {
            List<Integer> nextList = adj[cur];
            for (int next : nextList) {
                if (visited[next]) {
                    if (disMap.containsKey(next)) {
                        ansMax = Math.max(ansMax, level + 1 - disMap.getOrDefault(next, 0));
                    }
                    continue;
                }
                visited[next] = true;
                disMap.put(next, level + 1);
                dfs(next, adj, disMap, level + 1);
            }
        }

        public int longestCycle(int[] edges) {
            int n = edges.length;
            List<Integer>[] adj = new ArrayList[n];
            Arrays.setAll(adj, value -> new ArrayList<>());
            for (int i = 0; i < n; i++) {
                if (edges[i] == -1) {
                    continue;
                }
                adj[i].add(edges[i]);
            }

            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (adj[i].isEmpty()) {
                    continue;
                }
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                Map<Integer, Integer> disMap = new HashMap<>();
                disMap.put(i, 0);
                dfs(i, adj, disMap,0);
            }
            return ansMax;
        }
    }

}
