package doubleContest.round63;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/16
 */
public class C {

    // 从节点0到其他节点的最短距离
    private int[] dis;

    private void bfs(List<Integer>[] adj, int n) {
        boolean[] visited = new boolean[n];
        visited[0] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        int l = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            l++;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                List<Integer> nextList = adj[node];
                for (int next : nextList) {
                    if (visited[next]) {
                        continue;
                    }

                    dis[next] = l;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (adj[u] == null) {
                adj[u] = new ArrayList<>();
            }
            adj[u].add(v);
            if (adj[v] == null) {
                adj[v] = new ArrayList<>();
            }
            adj[v].add(u);
        }

        dis = new int[n];
        bfs(adj, n);

        int max = 0;
        for (int i = 1; i < n; i++) {
            dis[i] <<= 1;
            max = Math.max(max, dis[i] + (dis[i] - (dis[i] - 1) % patience[i]));
        }

        return max;
    }

}
