package contest.contest289;

import java.util.*;

public class D {

    private List<Integer>[] adj;
    private char[] arr;
    private Map<Long, Integer> memoMap;

    private int dp(int pre, int cur, boolean[] visited) {
        if (pre != -1 && arr[pre] == arr[cur] || visited[cur]) {
            return 0;
        }

        visited[cur] = true;
        long key = pre * 100000L + cur;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        List<Integer> nextList = adj[cur];
        int ansMax = 1;
        for (int next : nextList) {
            ansMax = Math.max(ansMax, dp(cur, next, visited) + 1);
        }

        memoMap.put(key, ansMax);
        return ansMax;
    }

    public int longestPath(int[] parents, String s) {
        int len = parents.length;
        if (len == 1) {
            return 1;
        }

        adj = new ArrayList[len];
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -1) {
                continue;
            }

            int u = i;
            int v = parents[i];
            if (adj[u] == null) {
                adj[u] = new ArrayList<>();
            }
            adj[u].add(v);

            if (adj[v] == null) {
                adj[v] = new ArrayList<>();
            }
            adj[v].add(u);
        }

        arr = s.toCharArray();
        memoMap = new HashMap<>();
        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            ansMax = Math.max(ansMax, dp(-1, i, new boolean[len]));
        }
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
