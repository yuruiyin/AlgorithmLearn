package contest.contest284;

import java.util.*;

public class D {

    /**
     * 单源最短路径算法
     */
    static class Dijkstra {

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

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<Dijkstra.Edge>[] g = new ArrayList[n];
        List<Dijkstra.Edge>[] rg = new ArrayList[n];
        Arrays.setAll(g, value -> new ArrayList<>());
        Arrays.setAll(rg, value -> new ArrayList<>());
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int w = edge[2];
            g[from].add(new Dijkstra.Edge(to, w));
            rg[to].add(new Dijkstra.Edge(from, w));
        }

        Dijkstra dijkstra = new Dijkstra();

        long[] disFrom1 = dijkstra.dijkstra(src1, g, n);
        long[] disFrom2 = dijkstra.dijkstra(src2, g, n);
        // 从dest到其他点的最短路径要用反图
        long[] disFromDest = dijkstra.dijkstra(dest, rg, n);
        if (disFrom1[dest] == Dijkstra.INF || disFrom2[dest] == Dijkstra.INF) {
            return -1;
        }

        long ansMin = Dijkstra.INF;
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
