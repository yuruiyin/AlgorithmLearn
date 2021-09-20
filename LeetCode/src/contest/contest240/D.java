package contest.contest240;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/9
 */
public class D {

    private char[] arr;
    private int len;
    private List<Integer>[] adj;
    private int[][] dp;
    private boolean[] gVisited;

    private int[] dfs(int cur) {
        if (dp[cur] != null) {
            return dp[cur];
        }

        int[] res = new int[26];
        res[arr[cur] - 'a']++;
        List<Integer> nextList = adj[cur];
        if (nextList == null) {
            dp[cur] = res;
            return res;
        }

        int[] max = new int[26];
        for (int next : nextList) {
            for (int i = 0; i < 26; i++) {
                max[i] = Math.max(max[i], dfs(next)[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            res[i] += max[i];
        }

        dp[cur] = res;
        return res;
    }

    // 判断有向图是否有环
    private void hasCircle(int from, boolean[] visited) throws Exception {
        if (gVisited[from]) {
            return;
        }

        gVisited[from] = true;

        List<Integer> nextList = adj[from];
        if (nextList == null) {
            return;
        }

        for (Integer next : nextList) {
            if (visited[next]) {
                throw new Exception();
            }

            visited[next] = true;
            hasCircle(next, visited);
            visited[next] = false;
        }
    }

    public int largestPathValue(String colors, int[][] edges) {
        arr = colors.toCharArray();
        len = arr.length;
        adj = new ArrayList[len];
        Set<Integer> nodeSet = new HashSet<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            nodeSet.add(from);
            nodeSet.add(to);
            if (adj[from] == null) {
                adj[from] = new ArrayList<>();
            }
            if (from == to) {
                return -1;
            }
            adj[from].add(to);
        }

        List<Integer> zeroInDegreeList = new ArrayList<>();
        int[] inDegree = new int[len];
        for (int i = 0; i < len; i++) {
            List<Integer> nextList = adj[i];
            if (nextList == null) {
                continue;
            }

            for (int next : nextList) {
                inDegree[next]++;
            }
        }

        for (int i = 0; i < len; i++) {
            if (inDegree[i] == 0 && nodeSet.contains(i)) {
                zeroInDegreeList.add(i);
            }
        }

        System.out.println("入度为0的节点个数: " + zeroInDegreeList.size());

        if (zeroInDegreeList.isEmpty() && !nodeSet.isEmpty()) {
            return -1;
        }

        gVisited = new boolean[len];
        for (int node : zeroInDegreeList) {
            if (adj[node] == null || gVisited[node]) {
                continue;
            }

            boolean[] visited = new boolean[len];
            visited[node] = true;
            try {
                hasCircle(node, visited);
            } catch (Exception e) {
                return -1;
            }
        }

        dp = new int[len][26];

        for (int i = 0; i < len; i++) {
            dp[i] = null;
        }

        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            int[] res = dfs(i);
            for (int j = 0; j < 26; j++) {
                ansMax = Math.max(ansMax, res[j]);
            }
        }

        return ansMax;
    }

}
