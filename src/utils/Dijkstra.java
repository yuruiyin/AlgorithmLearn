package utils;

import java.util.*;

/**
 * 单源最短路径算法
 */
public class Dijkstra {

    private static long INF = 0x0FFFFFFFFFFFFFFFL;

    private List<Edge>[] g;

    public Dijkstra(int[][] edges, int n) {
        g = new ArrayList[n];
        Arrays.setAll(g, value -> new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];
            int w = edge[2];
            g[from].add(new Dijkstra.Edge(to, w));
            g[to].add(new Dijkstra.Edge(from, w));
        }
    }

    static class Edge {
        int v;
        long w;

        Edge(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }

    private long[] dijkstra(int src1, int n) {
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

}
