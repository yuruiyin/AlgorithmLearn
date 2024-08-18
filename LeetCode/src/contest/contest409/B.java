package contest.contest409;

import java.awt.desktop.PrintFilesEvent;
import java.util.*;

public class B {

    class Interval {
        int s;
        int e;
        Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    private int bfs(List<Integer>[] adj, int n) {
        // 0 ~ n - 1 最短路
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.pollFirst();
                if (cur == n - 1) {
                    return ans;
                }
                List<Integer> nextList = adj[cur];
                for (int next : nextList) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.addLast(next);
                }
            }
            ans++;
        }
        return ans;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            adj[i].add(i + 1);
        }

        int qLen = queries.length;
        int[] ansArr = new int[qLen];
        for (int i = 0; i < qLen; i++) {
            int[] q = queries[i];
            int from = q[0];
            int to = q[1];
            adj[from].add(to);
            ansArr[i] = bfs(adj, n);
        }
        return ansArr;
    }

}
