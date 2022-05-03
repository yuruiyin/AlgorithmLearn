package doubleContest.round76;

import java.util.*;

/**
 * TLE
 */
public class D {

    private List<Integer>[] adj;
    private int[] scores;
    private int n;
    private Map<String, Integer> memoMap;

    private String getKey(int cur, TreeSet<Integer> preNodeSet) {
        StringBuilder sb = new StringBuilder(cur + ",");
        for (int node : preNodeSet) {
            sb.append(node).append(",");
        }
        return sb.toString();
    }

    private int dfs(int cur, TreeSet<Integer> preNodeSet) {
        if (preNodeSet.size() == 4) {
            return scores[cur];
        }

        String key = getKey(cur, preNodeSet);
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        List<Integer> nextList = adj[cur];
        if (nextList == null) {
            return -1;
        }

        int ansMax = -1;
        for (int next: nextList) {
            if (preNodeSet.contains(next)) {
                continue;
            }

            preNodeSet.add(next);
            int res = dfs(next, preNodeSet);
            preNodeSet.remove(next);
            if (res != -1) {
                ansMax = Math.max(ansMax, res + scores[cur]);
            }
        }

        memoMap.put(key, ansMax);
        return ansMax;
    }

    public int maximumScore(int[] scores, int[][] edges) {
        this.scores = scores;
        this.n = scores.length;
        adj = new ArrayList[50001];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (adj[u] == null) {
                adj[u] = new ArrayList<>();
            }
            adj[u].add(v);
            if (adj[v] == null) {
                adj[v] = new ArrayList<>();
            }
            adj[v].add(u);
        }

        memoMap = new HashMap<>();
        int ansMax = -1;
        for (int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            TreeSet<Integer> preNodeSet = new TreeSet<>();
            preNodeSet.add(node1);
            preNodeSet.add(node2);
            int res1 = dfs(node1, preNodeSet);
            int res2 = dfs(node2, preNodeSet);
            if (res1 != -1) {
                ansMax = Math.max(ansMax, res1 + scores[node2]);
            }
            if (res2 != -1) {
                ansMax = Math.max(ansMax, res2 + scores[node1]);
            }
        }
        return ansMax;
    }

}
