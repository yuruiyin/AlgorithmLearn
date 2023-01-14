package doubleContest.round091;

import java.util.*;

public class C {

    private List<Integer>[] adj;
    private int n;

    private int bob;

    private List<Integer> bobToAliceList;

    private int[] amount;

    private boolean dfsToBob(int cur, List<Integer> tmpNodeList, boolean[] visited) {
        if (cur == bob) {
            for (int i = tmpNodeList.size() - 1; i >= 0; i--) {
                bobToAliceList.add(tmpNodeList.get(i));
            }
            return true;
        }

        List<Integer> nextList = adj[cur];
        for (int next : nextList) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            tmpNodeList.add(next);
            boolean isFound = dfsToBob(next, tmpNodeList, visited);
            tmpNodeList.remove(tmpNodeList.size() - 1);
            visited[next] = false;
            if (isFound) {
                return true;
            }
        }

        return false;
    }

    private int dfs(int cur, int level, boolean[] visited, boolean[] visitedByBob) {
        int curCost = 0;
        if (level < bobToAliceList.size() && cur == bobToAliceList.get(level)) {
            // 一起到达
            curCost = amount[cur] / 2;
        } else if (visitedByBob[cur]) {
            curCost = 0;
        } else {
            curCost = amount[cur];
        }
        if (cur != 0 && adj[cur].size() == 1) {
            // 非根的叶子节点
            return curCost;
        }

        List<Integer> nextList = adj[cur];
        int maxCost = Integer.MIN_VALUE;
        for (int next : nextList) {
            if (visited[next]) {
                continue;
            }

            visited[next] = true;
            if (level + 1 < bobToAliceList.size()) {
                int bobNode = bobToAliceList.get(level + 1);
                visitedByBob[bobNode] = true;
            }
            int cost = dfs(next, level + 1, visited, visitedByBob);
            if (level + 1 < bobToAliceList.size()) {
                int bobNode = bobToAliceList.get(level + 1);
                visitedByBob[bobNode] = false;
            }
            maxCost = Math.max(maxCost, cost);
            visited[next] = false;
        }

        return curCost + maxCost;
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        n = edges.length + 1;
        adj = new ArrayList[n];
        this.bob = bob;
        this.amount = amount;
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        // 先求bob到0的路径
        bobToAliceList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfsToBob(0, new ArrayList<>(), visited);
//        for (int num : bobToAliceList) {
//            System.out.println(num);
//        }
        boolean[] visited1 = new boolean[n];
        visited1[0] = true;
        boolean[] bobVisited = new boolean[n];
        bobVisited[bob] = true;
        return dfs(0, 0, visited1, bobVisited);
    }

    public static void main(String[] args) {
//        System.out.println(new C().mostProfitablePath(new int[][]{{0,1},{1,2},{1,3},{3,4}}, 3, new int[]{-2,4,2,-4,6}));
        System.out.println(new C().mostProfitablePath(new int[][]{{0,1},{1,2},{2,3}}, 3, new int[]{-5644, -6018, 1188, -8502}));
    }

}
