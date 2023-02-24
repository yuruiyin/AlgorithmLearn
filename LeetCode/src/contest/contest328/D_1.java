package contest.contest328;

import java.util.*;

public class D_1 {

    private int[] price;
    private List<Integer>[] adj;
    private Map<Long, Long> memoMap;

    private long dfs(int parent, int cur) {
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
            ansMax = Math.max(ansMax, dfs(cur, next));
        }
        if (nextCount > 0) {
            ansMax += price[cur];
        }
        memoMap.put(key, ansMax);
        return ansMax;
    }

    public long maxOutput(int n, int[][] edges, int[] price) {
        this.price = price;
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
            ansMax = Math.max(ansMax, dfs(n, i));
        }
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println(new D_1().maxOutput(10, new int[][]{
                {0,1},{1,2},{1,3},{3,4},{3,5},{3,6},{2,7},{2,8},{0,9}
        }, new int[]{1,2,3,4,5,6,7,8,9,10}));
    }

}
