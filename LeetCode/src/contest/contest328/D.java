package contest.contest328;

import java.util.*;

public class D {

    private int[] price;
    private int n;

    private List<Integer>[] adj;

    private Map<Long, Long> memoMap;

    private long dp(int parent, int cur) {
        long key = parent * 100001L + cur;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        List<Integer> nextList = adj[cur];
        long ansMax = 0;
        long nextCount = 0;
        for (int next : nextList) {
            if (next == parent) {
                continue;
            }
            nextCount++;
            ansMax = Math.max(ansMax, dp(cur, next));
        }

        if (nextCount > 0) {
            ansMax += price[cur];
        }
        memoMap.put(key, ansMax);
        return ansMax;
    }

    public long maxOutput(int n, int[][] edges, int[] price) {
        this.price = price;
        this.n = n;
        adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        memoMap = new HashMap<>();
        long ansMax = 0;
        for (int i = 0; i < n; i++) {
            ansMax = Math.max(ansMax, dp(n, i));
        }

        return ansMax;
    }

}
