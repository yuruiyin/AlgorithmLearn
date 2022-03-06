package contest.contest266;

import java.util.*;

/**
 * D
 *
 * @author: yry
 * @date: 2021/11/7
 */
public class D {

    private int[] values;
    private List<Integer>[] adj;
    private int n;
    private int maxTime;
    private int ansMax;
    private int[][] timeArr;

    private int getValueSum(List<Integer> nodeList) {
        int sum = 0;
        Set<Integer> nodeSet = new HashSet<>(nodeList);
        for (int id : nodeSet) {
            sum += values[id];
        }
        return sum;
    }

    private void getMax(int from, int cur, List<Integer> nodeList, int timeSum) {
        if (timeSum > maxTime) {
            return;
        }

        if (from == cur) {
            ansMax = Math.max(ansMax, getValueSum(nodeList));
        }

        List<Integer> nextList = adj[cur];
        if (nextList == null) {
            return;
        }

        for (int next : nextList) {
            nodeList.add(next);
            getMax(from, next, nodeList, timeSum + timeArr[cur][next]);
            nodeList.remove(nodeList.size() - 1);
        }
    }

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        this.n = values.length;
        this.values = values;
        this.adj = new ArrayList[n];
        this.maxTime = maxTime;
        timeArr = new int[n][n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            timeArr[u][v] = time;
            timeArr[v][u] = time;
            if (adj[u] == null) {
                adj[u] = new ArrayList<>();
            }
            adj[u].add(v);
            if (adj[v] == null) {
                adj[v] = new ArrayList<>();
            }
            adj[v].add(u);
        }

        // 暴力
        ansMax = 0;
        List<Integer> nodeSet = new ArrayList<>();
        nodeSet.add(0);
        getMax(0, 0, nodeSet, 0);

        return ansMax;
    }

}
