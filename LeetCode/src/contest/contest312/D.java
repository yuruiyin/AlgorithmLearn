package contest.contest312;

import java.util.*;

public class D {

    private List<Integer>[] adj;
    private int n;

    private int addCount;

    private int[] vals;

    private boolean[] totalVisited;

    private void dfs(int from, int curNode, boolean[] visited) {
        if (curNode != from) {
            if (vals[from] == vals[curNode]) {
                addCount++;
            }
        }

        List<Integer> nextList = adj[curNode];
        for (int next : nextList) {
            if (visited[next]) {
                continue;
            }
            if (vals[next] > vals[from]) {
                continue;
            }
            visited[next] = true;
            dfs(from, next, visited);
            visited[next] = false;
        }
    }

    private void bfs(int from) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(from);
        boolean[] visited = new boolean[n];
        int count = 1;
        totalVisited[from] = true;
        visited[from] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curNode = queue.poll();
                if (curNode != from && vals[from] == vals[curNode]) {
                    count++;
                    totalVisited[curNode] = true;
                }

                List<Integer> nextList = adj[curNode];
                for (int next : nextList) {
                    if (visited[next]) {
                        continue;
                    }
                    if (vals[next] > vals[from]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        addCount += count * (count - 1) / 2;
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        this.n = vals.length;
        adj = new ArrayList[n];
        this.vals = vals;
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        int ans = n;
        addCount = 0;
        totalVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
//            boolean[] visited = new boolean[n];
//            visited[i] = true;
//            dfs(i, i, visited);
            if (totalVisited[i]) {
                continue;
            }
            bfs(i);
        }

        return ans + addCount;
    }

    private static int[] getVals() {
        int[] vals = new int[30000];
        Arrays.fill(vals, 1);
        return vals;
    }

    private static int[][] getEdges() {
        int[][] edges = new int[29999][2];
        for (int i = 0; i < 29999; i++) {
            edges[i][0] = i;
            edges[i][1] = i + 1;
        }
        return edges;
    }

    public static void main(String[] args) {
        // [1,3,2,1,3], edges = [[0,1],[0,2],[2,3],[2,4]]

        System.out.println(new D().numberOfGoodPaths(new int[]{1,3,2,1,3}, new int[][]{
                {0,1},{0,2},{2,3},{2,4}
        }));
        System.out.println(new D().numberOfGoodPaths(getVals(), getEdges()));
    }

}
