package problem1101_1200;

import java.util.*;

public class Problem1135 {

    class Edge {
        int node1;
        int node2;
        int cost;
        Edge(int node1, int node2, int cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }
    }

    class CustomCmp implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.cost - o2.cost; // 按边权从小到大排序
        }
    }

    private int getAns(List<Edge> edges, int nodeCount) {
        // 用于存放每个节点所在的树（这里的set是上面set的地址），当存在树进行合并的时候，需要更新这个值
        List<Integer>[] nodeTreeSetMap = new ArrayList[nodeCount + 1];

        int ans = 0;
        int curEdgeCount = 0;  //当前生成树中的边数
        int edgeSize = edges.size();
        int needEdgeCount = nodeCount - 1; //最小生成树需要的边数
        for (int i = 0; i < edgeSize; i++) {
            Edge edge = edges.get(i);
            int node1 = edge.node1;
            int node2 = edge.node2;

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

            ans += edge.cost;
            curEdgeCount++;
        }

        if (curEdgeCount != needEdgeCount) {
            return -1;
        }

        return ans;
    }

    public int minimumCost(int n, int[][] connections) {
        // 最小生成树算法，kruskal，从最小权值的边开始将边加入到树里头，同时每次要加入的两个节点不能在一颗树里（否则会形成环，也就是变成多余的边）
        // 直到最后所有的顶点都在一颗树内或者有n-1条边为止

        if (connections.length < n - 1) {
            return -1;
        }

        List<Edge> edges = new ArrayList<>();

        for (int[] connection : connections) {
            int v1 = connection[0];
            int v2 = connection[1];
            int cost = connection[2];
            edges.add(new Edge(v1, v2, cost));
        }

        edges.sort(new CustomCmp());

        return getAns(edges, n);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1135().minimumCost(3, new int[][]{
                {1,2,5},{1,3,6},{2,3,1}
        })); // 6

        System.out.println(new Problem1135().minimumCost(4, new int[][]{
                {1,2,3},{3,4,4}
        })); // 6
    }
    
}
