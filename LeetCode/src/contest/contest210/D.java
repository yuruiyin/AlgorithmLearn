package contest.contest210;

import utils.PrintUtil;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/11
 */
public class D {

    private List<Integer>[] adj;
    private int n;

    private Set<Integer>[] bfs(int cur) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(cur);
        boolean[] visited = new boolean[n + 1];
        Set<Integer>[] countArr = new HashSet[n];
        int dis = 0;
        while (!queue.isEmpty()) {
            dis++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                visited[node] = true;
                List<Integer> nextList = adj[node];
                for (int next : nextList) {
                    if (visited[next]) {
                        continue;
                    }

                    if (countArr[dis] == null) {
                        countArr[dis] = new HashSet<>();
                    }
                    int min = Math.min(cur, next);
                    int max = Math.max(cur, next);
                    countArr[dis].add(min * (n + 1) + max);
                    queue.add(next);
                }
            }
        }

        return countArr;
    }

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        adj = new ArrayList[n + 1];
        this.n = n;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (adj[u] == null) {
                adj[u] = new ArrayList<>();
            }
            adj[u].add(v);
            if (adj[v] == null) {
                adj[v] = new ArrayList<>();
            }
            adj[v].add(u);
        }

        Set<Integer>[][] setArr = new HashSet[n + 1][n];
        for (int i = 1; i <= n; i++) {
            setArr[i] = bfs(i);
        }

        int[] ansArr = new int[n - 1];
        Set<Integer>[] ansSetArr = new HashSet[n - 1];
        for (int i = 1; i <= n; i++) {
            Set<Integer>[] countArr = setArr[i];
            for (int d = 1; d < n; d++) {
                if (ansSetArr[d - 1] == null) {
                    ansSetArr[d - 1] = new HashSet<>();
                }
                if (countArr[d] != null) {
                    ansSetArr[d - 1].addAll(countArr[d]);
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            ansArr[i] = ansSetArr[i].size();
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[] ansArr = new D().countSubgraphsForEachDiameter(4, new int[][]{
                {1,2},{2,3},{2,4}
        });
        PrintUtil.printIntArray(ansArr);
    }

}
