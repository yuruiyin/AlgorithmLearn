package contest.contest304;

public class C_1 {

    private void dfs(int[] edges, int cur, boolean[] visited, int[] dis, int level) {
        int next = edges[cur];
        if (next == -1) {
            // 没有出边
            return;
        }
        if (visited[next]) {
            return;
        }
        visited[next] = true;
        dis[next] = level + 1;
        dfs(edges, next, visited, dis, level + 1);
    }

    /**
     * 因为题目说至多只有一个出边，因此无需使用adj（List<Integer>[]）的方式
     */
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        boolean[] visited1 = new boolean[n];
        int[] dis1 = new int[n];
        dis1[node1] = 0;
        visited1[node1] = true;
        dfs(edges, node1, visited1, dis1, 0);
        boolean[] visited2 = new boolean[n];
        int[] dis2 = new int[n];
        dis2[node2] = 0;
        visited2[node2] = true;
        dfs(edges, node2, visited2, dis2, 0);
        int ansMin = Integer.MAX_VALUE;
        for (int v = 0; v < n; v++) {
            if (visited1[v] && visited2[v]) {
                ansMin = Math.min(ansMin, Math.max(dis1[v], dis2[v]));
            }
        }

        int ansMinNum = Integer.MAX_VALUE;
        for (int v = 0; v < n; v++) {
            if (visited1[v] && visited2[v]) {
                int dis = Math.max(dis1[v], dis2[v]);
                if (dis == ansMin) {
                    ansMinNum = Math.min(ansMinNum, v);
                }
            }
        }
        return ansMinNum == Integer.MAX_VALUE ? -1 : ansMinNum;
    }

}
