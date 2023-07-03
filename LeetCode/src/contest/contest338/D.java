package contest.contest338;

import java.util.*;

public class D {

    public int collectTheCoins(int[] coins, int[][] edges) {
        // 构建一颗有根树，并从层级最大的开始遍历，每次遍历距离2的节点
        int n = edges.length + 1;
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        List<Integer>[] levelListArr = new ArrayList[n];
        Arrays.setAll(levelListArr, value -> new ArrayList<>());
        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        int level = 0;
        int[] parentArr = new int[n];
        Arrays.fill(parentArr, -1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                levelListArr[level].add(node);
                List<Integer> nextList = adj[node];
                for (int next : nextList) {
                    if (visited[next]) {
                        continue;
                    }
                    parentArr[next] = node;
                    visited[next] = true;
                    queue.add(next);
                }
            }
            level++;
        }

        // 从level最大开始遍历
        Set<Integer> set = new HashSet<>();
        boolean[] visited1 = new boolean[n];
        for (int i = level - 1; i >= 0; i--) {
            List<Integer> nodeList = levelListArr[i];
            for (int node : nodeList) {
                if (coins[node] == 1) {
                    if (set.contains(node)) {

                    }
                    if (i == 0) {
                        // 已经是根了
                        set.add(node);
                        break;
                    }
                    if (i == 1) {
                        // 第二层

                    }
                    int parent = parentArr[node];
                    int parentParent = parentArr[parent];

                }
            }
        }

        // todo
        return 0;
    }

}
