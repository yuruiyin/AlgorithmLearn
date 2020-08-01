package contest.contest197;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/12
 */
public class C_1 {

    private int end;
    private double[] memo;
    private List<Integer>[] adj;
    private Map<Integer, Double> probMap;
    private int n;

    private double dfs(int start) {
        if (start == end) {
            return 1.0;
        }

        if (memo[start] >= 0) {
            return memo[start];
        }

        List<Integer> nextList = adj[start];
        if (nextList == null) {
            return 0;
        }

        double ansMax = 0;
        for (Integer next : nextList) {
            if (memo[next] >= 0) {
                continue;
            }
            ansMax = Math.max(ansMax, probMap.get(start * n + next) * dfs(next));
        }

        memo[start] = ansMax;
        return ansMax;
    }

    private boolean isConnected(int start, boolean[] visited) {
        if (start == end) {
            return true;
        }

        visited[start] = true;

        List<Integer> nextList = adj[start];
        if (nextList == null) {
            return false;
        }

        for (Integer next : nextList) {
            if (visited[next]) {
                continue;
            }

            if (isConnected(next, visited)) {
                return true;
            }
        }

        return false;
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        this.n = n;
        adj = new ArrayList[n];
        probMap = new HashMap<>();
        int edgeCount = edges.length;
        for (int i = 0; i < edgeCount; i++) {
            int[] edge = edges[i];
            int v1 = edge[0];
            int v2 = edge[1];
            if (adj[v1] == null) {
                adj[v1] = new ArrayList<>();
            }
            adj[v1].add(v2);

            if (adj[v2] == null) {
                adj[v2] = new ArrayList<>();
            }
            adj[v2].add(v1);

            probMap.put(v1 * n + v2, succProb[i]);
            probMap.put(v2 * n + v1, succProb[i]);
        }

        memo = new double[n];
        Arrays.fill(memo, -1.0);
        this.end = end;
        if (!isConnected(start, new boolean[n])) {
           return 0;
        }

        return dfs(start);
    }

}
