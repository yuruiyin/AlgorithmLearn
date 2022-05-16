package contest.contest284;

import fall_2020.E;

import java.util.*;

public class D {

    static class Edge {
        int v;
        long w;

        Edge(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }

    private static long INF = 0x007FFFFFFFFFFFFFL;
    private int n;

    private long[] dijkstra(int src1, List<Edge>[] g) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w == o2.w ? o1.v - o2.v : Long.compare(o1.w, o2.w);
            }
        });
        boolean[] visited = new boolean[n];
        long[] dis = new long[n];
        Arrays.fill(dis, INF);
        queue.add(new Edge(src1, 0));
        dis[src1] = 0;
        while (!queue.isEmpty()) {
            Edge top = queue.poll();
            int cur = top.v;
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            List<Edge> nextList = g[cur];
            for (Edge next : nextList) {
                if (next.w + dis[cur] < dis[next.v]) {
                    dis[next.v] = next.w + dis[cur];
                    queue.add(new Edge(next.v, dis[next.v]));
                }
            }
        }
        return dis;
    }

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<Edge>[] g = new ArrayList[n];
        List<Edge>[] rg = new ArrayList[n];
        this.n = n;
        Arrays.setAll(g, value -> new ArrayList<>());
        Arrays.setAll(rg, value -> new ArrayList<>());
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int w = edge[2];
            g[from].add(new Edge(to, w));
            rg[to].add(new Edge(from, w));
        }

        long[] disFrom1 = dijkstra(src1, g);
        long[] disFrom2 = dijkstra(src2, g);
        // 从dest到其他点的最短路径要用反图
        long[] disFromDest = dijkstra(dest, rg);
        if (disFrom1[dest] == INF || disFrom2[dest] == INF) {
            return -1;
        }

        long ansMin = INF;
        for (int i = 0; i < n; i++) {
            ansMin = Math.min(ansMin, disFrom1[i] + disFrom2[i] + disFromDest[i]);
        }

        return ansMin;
    }

    public static void main(String[] args) {
        // n = 6, edges = [[0,2,2],[0,5,6],[1,0,3],[1,4,5],[2,1,1],[2,3,3],[2,3,4],[3,4,2],[4,5,1]], src1 = 0, src2 = 1, dest = 5
        //输出：9
        System.out.println(new D().minimumWeight(6, new int[][]{
                {0, 2, 2}, {0, 5, 6}, {1, 0, 3}, {1, 4, 5}, {2, 1, 1}, {2, 3, 3}, {2, 3, 4}, {3, 4, 2}, {4, 5, 1}
        }, 0, 1, 5));
    }

}
