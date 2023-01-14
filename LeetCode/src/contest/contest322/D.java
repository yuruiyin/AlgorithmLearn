package contest.contest322;

import java.util.*;

public class D {

//    1 <= n <= 500
//    1 <= edges.length <= 104
//    edges[i].length == 2
//    1 <= ai, bi <= n
//    ai != bi
    public int magnificentSets(int n, int[][] edges) {
        // bfs
        List<Integer>[] adj = new ArrayList[n + 1];
        Arrays.setAll(adj, value -> new ArrayList<>());
//        int[] degreeArr = new int[n + 1];
        boolean[][] flag = new boolean[n + 1][n + 1];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
            flag[u][v] = true;
            flag[v][u] = true;
//            degreeArr[u]++;
//            degreeArr[v]++;
        }

        int ans = 0;
        List<Integer>[] degreeNodeList = new ArrayList[n + 1];
        Arrays.setAll(degreeNodeList, value -> new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            int size = adj[i].size();
            if (size == 0) {
                ans++;
            }
            degreeNodeList[size].add(i);
        }

        boolean[] visited = new boolean[n + 1];
        // 如果存在三个节点自环的一定就分不了组
        for (int degree = 1; degree < n; degree++) {
            List<Integer> nodeList = degreeNodeList[degree];
            if (nodeList.isEmpty()) {
                continue;
            }

            int targetNode = -1;
            for (int node : nodeList) {
                if (visited[node]) {
                    continue;
                }
                targetNode = node;
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(targetNode);
                int level = 0;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    level++;
                    boolean[] tmpVisited = new boolean[n + 1];
                    for (int tmpNode : queue) {
                        tmpVisited[tmpNode] = true;
                    }
                    for (int i = 0; i < size; i++) {
                        int node1 = queue.pollFirst();
                        visited[node1] = true;
                        List<Integer> nextList = adj[node1];
                        for (int next : nextList) {
                            if (visited[next]) {
                                continue;
                            }
                            if (tmpVisited[next]) {
                                return -1;
                            }
                            queue.addLast(next);
                        }
                    }
                }
                ans += level;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new D().magnificentSets(3, new int[][]{
//                {1,2},{2,3},{3,1}
//        }));

//        System.out.println(new D().magnificentSets(6, new int[][]{
//                {1,2},{1,4},{1,5},{2,6},{2,3},{4,6}
//        }));
        System.out.println(new D().magnificentSets(30, new int[][]{
                {16,8},{6,5}
        }));
    }

}
