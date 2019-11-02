package problem1101_1200;

import java.util.*;

/**
 * 数组遍历还是比List快
 */
public class Problem1135_1 {

    class CustomCmp implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[2] - o2[2];  // 按照cost从小到大排序
        }
    }

    private int kruskal(int[][] connections, int nodeCount) {
        // 用于存放每个节点所在的树，当存在树进行合并的时候，需要更新这个值
        List<Integer>[] nodeTreeSetMap = new ArrayList[nodeCount + 1];

        int ans = 0;
        int curEdgeCount = 0;  //当前生成树中的边数
        int edgeSize = connections.length;
        int needEdgeCount = nodeCount - 1; //最小生成树需要的边数
        for (int i = 0; i < edgeSize; i++) {
            int[] connection = connections[i];
            int node1 = connection[0];
            int node2 = connection[1];

            if (edgeSize - i + curEdgeCount < needEdgeCount) {
                // 后面剩余的边数已经不够了，直接返回就可以了
                return -1;
            }

            if (curEdgeCount == needEdgeCount) {
                break;
            }

            if (nodeTreeSetMap[node1] != null && nodeTreeSetMap[node2] != null) {
                // 都在树中，可能是同一颗树，可能是不同树
                List<Integer> set1 = nodeTreeSetMap[node1];
                List<Integer> set2 = nodeTreeSetMap[node2];
                if (set1 == set2) { //在同一棵树中
                    continue;
                }

                // 合并树，节点少的往节点多的合并
                if (set1.size() < set2.size()) {
                    set2.addAll(set1);
                    // 保留set2，要删除set1，因此更新set1中所有节点的nodeTreeSetMap
                    for (Integer node: set1) {
                        nodeTreeSetMap[node] = set2;
                    }
                } else {
                    set1.addAll(set2);
                    // 保留set1，要删除set2，因此更新set2中所有节点的nodeTreeSetMap
                    for (Integer node: set2) {
                        nodeTreeSetMap[node] = set1;
                    }
                }
            } else if (nodeTreeSetMap[node1] != null && nodeTreeSetMap[node2] == null) {
                // node1已在树中，node2不在树中, node2直接加入到node1所在的树即可
                List<Integer> set1 = nodeTreeSetMap[node1];
                set1.add(node2);
                nodeTreeSetMap[node2] = set1;
            } else if (nodeTreeSetMap[node2] != null && nodeTreeSetMap[node1] == null) {
                // node2已在树中，node1不在树中, node1直接加入到node2所在的树即可
                List<Integer> set2 = nodeTreeSetMap[node2];
                set2.add(node1);
                nodeTreeSetMap[node1] = set2;
            } else {
                // 两者都不在已有树中
                List<Integer> set = new ArrayList<>();
                set.add(node1);
                set.add(node2);
                nodeTreeSetMap[node1] = set;
                nodeTreeSetMap[node2] = set;
            }

            ans += connection[2];
            curEdgeCount++;
        }

        if (curEdgeCount != needEdgeCount) {
            return -1;
        }

        return ans;
    }

    /**
     * 通过BFS判断所有节点是否连通
     */
    private boolean isConnectedByBFS(int n, int[][] connections) {
        ArrayList<Integer>[] adj = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] connection: connections) {
            int v1 = connection[0];
            int v2 = connection[1];
            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(1);

        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        int nodeCount = 0;

        while (!queue.isEmpty()) {
            int front = queue.removeFirst();
            nodeCount++;

            List<Integer> neighbors = adj[front];
            for (int neighbor : neighbors) {
                if (visited[neighbor]) {
                    continue;
                }
                queue.addLast(neighbor);
                visited[neighbor] = true;
            }
        }

        return nodeCount == n;
    }

    public int minimumCost(int n, int[][] connections) {
        // 最小生成树算法，kruskal，从最小权值的边开始将边加入到树里头，同时每次要加入的两个节点不能在一颗树里（否则会形成环，也就是变成多余的边）
        // 直到最后所有的顶点都在一颗树内或者有n-1条边为止

        if (connections.length < n - 1) {
            return -1;
        }

        if (!isConnectedByBFS(n, connections)) {
            return -1;
        }

        // 按cost从小到大排序
//        Arrays.sort(connections, Comparator.comparingInt(o -> o[2]));  // 这样写会慢一些
//        Arrays.sort(connections, (o1, o2) -> o1[2] - o2[2]); // 这样写也会慢一些
        // 这样最快
        Arrays.sort(connections, new CustomCmp());

        return kruskal(connections, n);
    }

    public static void main(String[] args) {
        System.out.println(new Problem1135_1().minimumCost(3, new int[][]{
                {1,2,5},{1,3,6},{2,3,1}
        })); // 6

        System.out.println(new Problem1135_1().minimumCost(4, new int[][]{
                {1,2,3},{3,4,4}
        })); // 6
    }

}
