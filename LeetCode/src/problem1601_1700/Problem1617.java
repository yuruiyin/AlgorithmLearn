package problem1601_1700;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1617 {

    private List<Integer>[] adj;
    private int n;

    private int dfsCalcLen(int pre, int cur, int subSet) {
        List<Integer> nextList = adj[cur];
        int maxLen = 0;
        for (int next : nextList) {
            if (next == pre || (subSet & (1 << next)) == 0) {
                continue;
            }
            maxLen = Math.max(maxLen, dfsCalcLen(cur, next, subSet) + 1);
        }
        return maxLen;
    }

    private int dfsCalcLen1(int pre, int cur, int subSet, int tmpLen, int targetLen) {
        if (tmpLen == targetLen) {
            return cur;
        }

        List<Integer> nextList = adj[cur];
        for (int next : nextList) {
            if (next == pre || (subSet & (1 << next)) == 0) {
                continue;
            }
            int res = dfsCalcLen1(cur, next, subSet, tmpLen + 1, targetLen);
            if (res != -1) {
                return res;
            }
        }

        return -1;
    }

    /**
     * 判断子集是连通，如果连通，则判断最大直径
     * @param subSet 如 010110
     */
    private void handleSubSet(int subSet, int[] ansArr) {
        if (subSet == 0) {
            return;
        }

        int nodeCount = Integer.bitCount(subSet);
        if (nodeCount == 1) {
            return;
        }
        int oneNode = -1;
        for (int i = 0; i < n; i++) {
            if ((subSet & (1 << i)) != 0) {
                oneNode = i;
                break;
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(oneNode);
        int curNodeCount = 0;
        int visited = 0;
        visited |= 1 << oneNode;
        List<Integer> nodeList = new ArrayList<>();
        int[] degree = new int[n];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodeList.add(node);
            curNodeCount++;
            List<Integer> nextList = adj[node];
            for (int next: nextList) {
                int flag = 1 << next;
                if ((visited & flag) != 0) {
                    degree[node]++;
                    continue;
                }
                if ((subSet & flag) == 0) {
                    continue;
                }
                degree[node]++;
                visited |= flag;
                queue.add(next);
            }
        }

        if (curNodeCount == nodeCount) {
            // 说明连通，是一颗树，然后求树的直径，取两个不同的叶子dfs取最大者即可
            int maxLen = 0;
            for (int i = 0; i < curNodeCount; i++) {
                int node = nodeList.get(i);
                if (degree[node] == 1) {
                    int len = dfsCalcLen(-1, node, subSet);
                    int anotherLeafNode = dfsCalcLen1(-1, node, subSet, 0, len);
                    int len1 = dfsCalcLen(-1, anotherLeafNode, subSet);
                    maxLen = Math.max(len, len1);
                    break;
                }
            }
            ansArr[maxLen - 1]++;
        }
    }

    private void dfs(int idx, int subSet, int[] ansArr) {
        if (idx == n) {
            handleSubSet(subSet, ansArr);
            return;
        }

        dfs(idx + 1, subSet | (1 << idx), ansArr);
        dfs(idx + 1, subSet, ansArr);
    }

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u - 1].add(v - 1);
            adj[v - 1].add(u - 1);
        }

        int[] ansArr = new int[n - 1];
        dfs(0, 0, ansArr);
        return ansArr;
    }

}
