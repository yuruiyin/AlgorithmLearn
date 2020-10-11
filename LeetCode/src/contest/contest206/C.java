package contest.contest206;

import problem1101_1200.Problem1135_1;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/13
 */
public class C {

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
            if (node1 == node2) {
                continue;
            }

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

    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        int[][] connections = new int[len * len][3];
        int index = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }

                connections[index][0] = i;
                connections[index][1] = j;
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                connections[index][2] = cost;
                index++;
            }
        }

        Arrays.sort(connections, new CustomCmp());
        return kruskal(connections, len);
    }

    public static void main(String[] args) {
        System.out.println(new C().minCostConnectPoints(new int[][]{
                {0,0},{2,2},{3,10},{5,2},{7,0}
        }));
    }

}
