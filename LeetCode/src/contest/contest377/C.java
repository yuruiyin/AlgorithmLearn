package contest.contest377;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

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

    private void rec(int from, int cur, int[][] costArr, boolean[] visited) {
        visited[cur] = true;
        for (int i = 0; i < 26; i++) {
            if (visited[i]) {
                continue;
            }
            int cost = costArr[cur][i];
            if (cost == INF + 1) {
                continue;
            }
            costArr[from][i] = Math.min(costArr[from][i], costArr[from][cur] + cost);
            rec(from, i, costArr, visited);
        }
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        //  26 * 26
        int[][] costArr = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(costArr[i], INF);
        }
        for (int i = 0; i < 26; i++) {
            costArr[i][i] = 0;
        }
        int costLen = original.length;
        for (int i = 0; i < costLen; i++) {
            costArr[original[i] - 'a'][changed[i] - 'a'] = Math.min(costArr[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }

        char[] sourceArr = source.toCharArray();
        char[] targetArr = target.toCharArray();
        int len = sourceArr.length;

        // bfs
        G = new ArrayList[26 + 1];
        for (int i = 0; i <= 26; ++i) {
            G[i] = new ArrayList<>();
        }
        for (int u = 0; u < 26; u++) {
            for (int v = 0; v < 26; v++) {
                if (costArr[u][v] == INF) {
                    continue;
                }
                G[u].add(new Edge(v, costArr[u][v]));
            }
        }
        for (int i = 0; i < 26; i++) {
            dis = new int[26 + 1];
            vis = new boolean[26 + 1];
            Arrays.fill(dis, INF);
            Arrays.fill(vis, false);
            dijkstra(i);
            for (int j = 0; j < 26; j++) {
                costArr[i][j] = dis[j];
            }
        }

        long sum = 0;
        for (int i = 0; i < len; i++) {
            int sourceInt = sourceArr[i] - 'a';
            int targetInt = targetArr[i] - 'a';
            if (sourceInt == targetInt) {
                continue;
            }
            if (costArr[sourceInt][targetInt] == INF) {
                return -1;
            }
            sum += costArr[sourceInt][targetInt];
        }
        return sum;
    }

}
