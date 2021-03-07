package contest.contest231;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/7
 */
public class C {

    static class Edge implements Comparable<Edge> {
        int to;
        int w;

        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }

        public int compareTo(Edge obj) {
            return this.w - obj.w;
        }
    }

    static int INF = 0x7fffffff;
    static int[] dis;
    static boolean[] vis;
    static ArrayList<Edge>[] G;

    private void init(int n) {
        dis = new int[n + 1];
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

    private long dp(int from) {
        if (from == n) {
            return 1;
        }

        if (memo[from] != -1) {
            return memo[from];
        }

        List<Edge> nextList = G[from];
        long ans = 0;
        for (Edge edge : nextList) {
            int next = edge.to;
            if (dis[from] > dis[next]) {
                ans = (ans + dp(next)) % MOD;
            }
        }

        memo[from] = ans;
        return memo[from];
    }

    public int countRestrictedPaths(int n, int[][] edges) {
        init(n);
        this.n = n;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            G[u].add(new Edge(v, w));
            G[v].add(new Edge(u, w));
        }

        dijkstra(n);

//        for (int i = 1; i <= n - 1; i++) {
//            System.out.println(dis[i]);
//        }

        memo = new long[n + 1];
        Arrays.fill(memo, -1);
        return (int) (dp(1) % MOD);
    }
    
    public static void main(String[] args) {
        System.out.println(new C().countRestrictedPaths(5, new int[][]{
                {1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}
        }));
    }

}
