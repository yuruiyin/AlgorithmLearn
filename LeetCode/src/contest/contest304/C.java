package contest.contest304;

import java.util.*;

public class C {

    private void dfs(List<Integer>[] adj, int cur, Set<Integer> set, int[] dis, int level) {
        List<Integer> nextList = adj[cur];
        for (int next : nextList) {
            if (set.contains(next)) {
                continue;
            }
            set.add(next);
            dis[next] = level + 1;
            dfs(adj, next, set, dis, level + 1);
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if (edges[i] == -1) {
                continue;
            }
            adj[i].add(edges[i]);
        }

        Set<Integer> set1 = new HashSet<>();
        int[] dis1 = new int[n];
        dis1[node1] = 0;
        set1.add(node1);
        dfs(adj, node1, set1, dis1, 0);
        Set<Integer> set2 = new HashSet<>();
        int[] dis2 = new int[n];
        dis2[node2] = 0;
        set2.add(node2);
        dfs(adj, node2, set2, dis2, 0);
        int ansMin = Integer.MAX_VALUE;
        for (int v1 : set1) {
            if (set2.contains(v1)) {
                ansMin = Math.min(ansMin, Math.max(dis1[v1], dis2[v1]));
            }
        }

        int ansMinNum = Integer.MAX_VALUE;
        for (int v1 : set1) {
            if (set2.contains(v1)) {
                int dis = Math.max(dis1[v1], dis2[v1]);
                if (dis == ansMin) {
                    ansMinNum = Math.min(ansMinNum, v1);
                }
            }
        }

        return ansMinNum == Integer.MAX_VALUE ? -1 : ansMinNum;
    }

}
