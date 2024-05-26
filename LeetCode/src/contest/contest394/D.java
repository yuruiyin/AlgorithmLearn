package contest.contest394;

import java.util.*;

public class D {

    private static final long N = 50001;

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
            PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.w == o2.w ? o1.v - o2.v : Long.compare(o1.w, o2.w));
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

    private boolean[] bfs(long[] dist, int n, Map<Long, Integer> indexMap, List<Dijkstra.Edge>[] g, int edgeLen) {
        LinkedList<Dijkstra.Edge> queue = new LinkedList<>();
        queue.add(new Dijkstra.Edge(0, 0));
        boolean[] visited = new boolean[n];

        // 求所有dijkstra最短路径
        LinkedList<Integer>[] pathQueue = new LinkedList[n];
        Arrays.setAll(pathQueue, value -> new LinkedList<>());

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Dijkstra.Edge top = queue.poll();
                int cur = top.v;
                if (visited[cur]) {
                    continue;
                }
                visited[top.v] = true;
                List<Dijkstra.Edge> nextList = g[cur];
                for (Dijkstra.Edge next : nextList) {
                    if (next.w + dist[cur] == dist[next.v]) {
                        queue.add(new Dijkstra.Edge(next.v, dist[next.v]));
                        pathQueue[next.v].add(cur);
                    }
                }
            }
        }

        boolean[] ans = new boolean[edgeLen];
        LinkedList<Integer> tmpQueue = new LinkedList<>();
        tmpQueue.add(n - 1);
        boolean[] tmpVisited = new boolean[n];
        while (!tmpQueue.isEmpty()) {
            int size = tmpQueue.size();
            for (int i = 0; i < size; i++) {
                int cur = tmpQueue.poll();
                if (tmpVisited[cur]) {
                    continue;
                }
                tmpVisited[cur] = true;
                List<Integer> nextList = pathQueue[cur];
                for (int next : nextList) {
                    long key = next * N + cur;
                    ans[indexMap.get(key)] = true;
                    tmpQueue.add(next);
                }
            }
        }

        return ans;
    }

    public boolean[] findAnswer(int n, int[][] edges) {
        List<Dijkstra.Edge>[] g = new ArrayList[n];
        Arrays.setAll(g, value -> new ArrayList<>());
        Map<Long, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];
            int w = edge[2];
            g[from].add(new Dijkstra.Edge(to, w));
            g[to].add(new Dijkstra.Edge(from, w));
            indexMap.put(from * N + to, i);
            indexMap.put(to * N + from, i);
        }

        Dijkstra dijkstra = new Dijkstra();
        long[] dist = dijkstra.dijkstra(0, g, n);
        return bfs(dist, n, indexMap, g, edges.length);
    }

}
