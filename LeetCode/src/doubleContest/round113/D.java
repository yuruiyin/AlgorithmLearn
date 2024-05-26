package doubleContest.round113;

import java.util.*;

public class D {

    private static final long N = (long) (1e5 + 1);

    private List<Integer>[] adj;

    private Set<Long> edgeSet;

    private Map<Long, Integer> edgeIdxMap;

    private Integer[][] memo;

    private int dp(int preIdx, int curIdx) {
        int edgeIdx = edgeIdxMap.get(preIdx * N + curIdx);
        int flag = edgeSet.contains(preIdx * N + curIdx) ? 0 : 1;
        if (memo[edgeIdx][flag] != null) {
            return memo[edgeIdx][flag];
        }

        int res = 0;
        if (flag == 1) {
            res++;
        }

        List<Integer> nextList = adj[curIdx];
        for (int next: nextList) {
            if (next == preIdx) {
                continue;
            }
            res += dp(curIdx, next);
        }

        return memo[edgeIdx][flag] = res;
    }

    public int[] minEdgeReversals(int n, int[][] edges) {
        edgeSet = new HashSet<>();
        adj = new ArrayList[n];
        edgeIdxMap = new HashMap<>();
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            int u = e[0];
            int v = e[1];
            adj[u].add(v);
            adj[v].add(u);
            edgeSet.add(u * N + v);
            edgeIdxMap.put(u * N + v, i);
            edgeIdxMap.put(v * N + u, i);
        }

        memo = new Integer[n][2];
        int[] ansArr = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> nextList = adj[i];
            for (int next : nextList) {
                int edgeIdx = edgeIdxMap.get(i * N + next);
                int flag = edgeSet.contains(i * N + next) ? 0 : 1;
                if (memo[edgeIdx][flag] != null) {
                    ansArr[i] += memo[edgeIdx][flag];
                    continue;
                }
                ansArr[i] += dp(i, next);
            }
        }
        return ansArr;
    }

    /**
     * 构造星状图
     */
    private static int[][] createStarEdge() {
        int N = 100000;
        int[][] edges = new int[N][2];
        for (int i = 0; i < N; i++) {
            edges[i] = new int[]{0, i};
        }
        return edges;
    }

    public static void main(String[] args) {
        int[][] edges = createStarEdge();
        int[] ansArr = new D().minEdgeReversals(edges.length + 1, edges);
    }

}
