package contest.contest381;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class B {

    public int[] countOfPairs(int n, int x, int y) {
        // bfs
        List<Integer>[] adj = new ArrayList[n + 1];
        Arrays.setAll(adj, v -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            adj[i].add(i + 1);
            adj[i + 1].add(i);
        }

        if (Math.abs(x - y) != 1) {
            adj[x].add(y);
            adj[y].add(x);
        }

        int[] ans = new int[n];
        for (int i = 1; i <= n; i++) {
            // 从任意点出发进行bfs
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(i);
            boolean[] visited = new boolean[n + 1];
            visited[i] = true;
            int level = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int cur = queue.poll();
                    List<Integer> nextList = adj[cur];
                    for (int next : nextList) {
                        if (visited[next]) {
                            continue;
                        }

                        visited[next] = true;
                        ans[level]++;
                        queue.add(next);
                    }
                }
                level++;
            }
        }
        return ans;
    }

}
