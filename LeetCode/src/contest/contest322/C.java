package contest.contest322;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C {

    private List<Integer>[] adj;

    private boolean isConnect(int cur, int target, boolean[] visited) {
        if (cur == target) {
            return true;
        }

        visited[cur] = true;

        List<Integer> nextList = adj[cur];
        for (int next : nextList) {
            if (visited[next]) {
                continue;
            }
            if (isConnect(next, target, visited)) {
                visited[cur] = false;
                return true;
            }
        }
        visited[cur] = false;
        return false;
    }

    public int minScore(int n, int[][] roads) {
        List<int[]>[] disNodeList = new ArrayList[10001];
        Arrays.setAll(disNodeList, value -> new ArrayList<>());
        adj = new ArrayList[n + 1];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dis = road[2];
            disNodeList[dis].add(new int[]{u, v});
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int dis = 1; dis <= 10000; dis++) {
            List<int[]> nodeList = disNodeList[dis];
            for (int[] edge : nodeList) {
                int u = edge[0];
                int v = edge[1];
                // 看是否1可以到达u且n可到达v，或者反过来
                if (isConnect(1, u, new boolean[n + 1]) && isConnect(n, v, new boolean[n + 1]) ||
                        (isConnect(1, v, new boolean[n + 1]) && isConnect(n, u, new boolean[n + 1]))) {
                    return dis;
                }
            }
        }
        return -1;
    }

}
