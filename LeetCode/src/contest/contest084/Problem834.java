package contest.contest084;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem834 {

    private List<Integer>[] adj;
    private Map<Integer, Data> memoMap;

    class Data {
        int nodesCount; // 子树（包括自身）的节点个数
        int nodeDisSum; // 子树各点到自身的距离和

        Data(int nodesCount, int nodeDisSum) {
            this.nodesCount = nodesCount;
            this.nodeDisSum = nodeDisSum;
        }
    }

    // 思路：一个节点到所有子节点的距离之和设为dp[u], 假设u还有两个子节点v1,v2,
    // 那么dp[u] = dp[v1] + dp[v2] + (count(v1) + count(v2)) * 1
    private Data dfs(int nodeIndex, boolean[] nodeVisited) {
        List<Integer> neighbors = adj[nodeIndex];

        int resNodesCount = 1;
        int resNodeDisSum = 0;
        nodeVisited[nodeIndex] = true;
        for (Integer node: neighbors) {
            if (nodeVisited[node]) {
                continue;
            }

            Data tmpData;
            int key = nodeIndex * 10000 + node;
            // 假设之前已经算过从节点2到节点3，这个方向上以3为根的子树的结果，下次就不要重复计算。
            if (memoMap.containsKey(key)) {
                tmpData = memoMap.get(key);
            } else {
                tmpData = dfs(node, nodeVisited);
                memoMap.put(key, tmpData);
            }

            resNodesCount += tmpData.nodesCount;
            resNodeDisSum += tmpData.nodesCount + tmpData.nodeDisSum;
        }

        return new Data(resNodesCount, resNodeDisSum);
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        memoMap = new HashMap<>();
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            int first = edge[0];
            int second = edge[1];
            adj[first].add(second);
            adj[second].add(first);
        }

        int[] ansArr = new int[n];
        for (int i = 0; i < n; i++) {
            Data resData = dfs(i, new boolean[n]);
            ansArr[i] += resData.nodeDisSum;
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[][] edges = new int[5][2];
        edges[0] = new int[]{0,1};
        edges[1] = new int[]{0,2};
        edges[2] = new int[]{2,3};
        edges[3] = new int[]{2,4};
        edges[4] = new int[]{2,5};
        int[] arr = new Problem834().sumOfDistancesInTree(6, edges);

        PrintUtil.printIntArray(arr);
    }

}
