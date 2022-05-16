package utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 单源最短路径算法
 */
public class Dijkstra {

    private static long INF = 0x0FFFFFFFFFFFFFFFL;

    static class Edge {
        int v;
        long w;

        Edge(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }

    private long[] dijkstra(int src1, List<Edge>[] g, int n) {
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
