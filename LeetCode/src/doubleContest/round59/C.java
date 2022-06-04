package doubleContest.round59;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * A
 *
 * @author: yry
 * @date: 2021/8/21
 */
public class C {

    static class Edge implements Comparable<Edge> {
        int to;
        long w;

        Edge(int to, long w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.w, o.w);
        }

    }

    static long INF = 0x7fffffffffffffffL;
    static long[] dis;
    static boolean[] vis;
    static ArrayList<Edge>[] G;

    private void init(int n) {
        dis = new long[n + 1];
        vis = new boolean[n + 1];
        G = new ArrayList[n + 1];
        Arrays.fill(dis, INF);
        Arrays.fill(vis, false);
        for (int i = 0; i <= n; ++i) {
            G[i] = new ArrayList<>();
        }
    }

    /**
     * 单源最短路径dijkstra
     * @param s 源
     */
    private void dijkstra(int s) {
        PriorityQueue<Edge> que = new PriorityQueue<>();
        que.add(new Edge(s, 0));
        dis[s] = 0;
        while (!que.isEmpty()) {
            int u = que.poll().to;
            if (vis[u]) continue;
            vis[u] = true;
            for (int i = 0; i < G[u].size(); ++i) {
                Edge temp = G[u].get(i);
                if (dis[temp.to] > dis[u] + temp.w) {
                    dis[temp.to] = dis[u] + temp.w;
                    que.add(new Edge(temp.to, dis[temp.to]));
                }
            }
        }
    }

    private long[] memo;
    private int n;
    private static final int MOD = (int) (1e9 + 7);

    private long dp(int from, long target) {
        if (from == n) {
            return 1;
        }

        if (dis[from] > target || target <= 0) {
            return 0;
        }

        if (memo[from] != -1) {
            return memo[from];
        }

        List<Edge> nextList = G[from];
        long ans = 0;
        for (Edge edge : nextList) {
            int next = edge.to;
            if (dis[next] == target - edge.w) {
                ans = (ans + dp(next, target - edge.w)) % MOD;
            }
        }

        memo[from] = ans;
        return memo[from];
    }

    public int countPaths(int n, int[][] edges) {
        init(n);
        this.n = n;
        for (int[] edge : edges) {
            int u = edge[0] + 1;
            int v = edge[1] + 1;
            int w = edge[2];
            G[u].add(new Edge(v, w));
            G[v].add(new Edge(u, w));
        }

        dijkstra(n);

        System.out.println(dis[1]);
//        for (int i = 1; i <= n - 1; i++) {
//            System.out.println(dis[i]);
//        }

        memo = new long[n + 1];
        Arrays.fill(memo, -1);
        return (int) (dp(1, dis[1]) % MOD);
    }

}
