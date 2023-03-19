package doubleContest.round099;

import java.util.*;

public class D {

    private Map<Long, Integer> memoMap;

    private List<Integer>[] adj;

    private static final long N = 100001L;

    private Map<Long, Integer> guessCountMap;

    private int[] parentArr;

    private int rec(int parent, int cur) {
        long key = parent * N + cur;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        parentArr[cur] = parent;
        List<Integer> nextList = adj[cur];
        int resCount = guessCountMap.getOrDefault(key, 0);
        for (int next: nextList) {
            if (next == parent) {
                continue;
            }
            resCount += rec(cur, next);
        }

        memoMap.put(key, resCount);
        return resCount;
    }

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n = edges.length + 1;
        adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        guessCountMap = new HashMap<>();
        for (int[] guess : guesses) {
            int u = guess[0];
            int v = guess[1];
            long key = u * N + v;
            guessCountMap.put(key, guessCountMap.getOrDefault(key, 0) + 1);
        }
        memoMap = new HashMap<>();
        int ans = 0;
        parentArr = new int[n];
        Arrays.fill(parentArr, n);
        int count = rec(n, 0);
        if (count >= k) {
            ans++;
        }

        return ans;
    }

    private static int[][] createEdges() {
        int n = 100000;
        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = 0;
            edges[i][1] = i + 1;
        }
        return edges;
    }

    public static void main(String[] args) {
        int[][] edges = createEdges();
        int[][] guess = edges;
        System.out.println(new D().rootCount(edges, guess, 100000));
    }

}
