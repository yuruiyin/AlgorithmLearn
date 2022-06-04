package contest.contest295;

import utils.Dijkstra;

import java.util.*;

public class D {

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

    public int minimumObstacles(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        int N = 100001;
        List<Dijkstra.Edge>[] g = new ArrayList[N];
        Arrays.setAll(g, value -> new ArrayList<>());
        Dijkstra dijkstra = new Dijkstra();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int curIdx = i * colCount + j;
                for (int k = 0; k < 4; k++) {
                    int nextRow = i + dx[k];
                    int nextCol = j + dy[k];
                    if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount) {
                        continue;
                    }
                    int nextIdx = nextRow * colCount + nextCol;
                    int w = grid[nextRow][nextCol];
                    g[curIdx].add(new Dijkstra.Edge(nextIdx, w));
                }
            }
        }

        int src = 0;
        int dest = (rowCount - 1) * colCount + (colCount - 1);
        long[] dis = dijkstra.dijkstra(0, g, N);
        return (int) dis[dest];
    }

}
