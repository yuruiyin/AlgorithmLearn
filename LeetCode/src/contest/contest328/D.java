package contest.contest328;

import java.util.*;

public class D {

    private int[] price;
    private List<Integer>[] adj;
    private Map<Long, Long> memoMap;

    private int count;
    
    private int dpCount;

    private long dp(int parent, int cur) {
        long key = parent * 100001L + cur;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        dpCount++;

        List<Integer> nextList = adj[cur];
        long ansMax = 0;
        long nextCount = 0;
        for (int next : nextList) {
            if (next == parent) {
                continue;
            }
            nextCount++;
            count++;
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
        adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        memoMap = new HashMap<>();
        System.out.println("hello");
        long ansMax = 0;
        for (int i = 0; i < n; i++) {
            ansMax = Math.max(ansMax, dp(n, i));
        }

        System.out.println(count);
        
        System.out.println(dpCount);

        return ansMax;
    }

    private static int[][] createEdge(int n) {
        int[][] ansEdge = new int[n - 1][2];
        for (int i = 1; i < n; i++) {
            ansEdge[i-1] = new int[]{i, 0};
        }
        return ansEdge;
    }

    private static int[] createPrice(int n) {
        int[] ansPrice = new int[n];
        for (int i = 0; i < n; i++) {
            ansPrice[i] = i + 1;
        }
        return ansPrice;
    }

    public static void main(String[] args) {
//        System.out.println(new D().maxOutput(14, new int[][]{
//                {0,1},{1,2},{1,3},{3,4},{3,5},{3,6},{2,7},{2,8},{0,9},{0,10},{1,11},{2,12},{0,13}
//        }, new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14}));
        int n = 100000;
        System.out.println(new D().maxOutput(n, createEdge(n), createPrice(n)));
    }

}
