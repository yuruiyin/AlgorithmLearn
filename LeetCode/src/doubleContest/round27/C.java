package doubleContest.round27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/30
 */
public class C {

    private List<Integer>[] adj;
    private Boolean[][] memo;

    private boolean dfs(int from, int to, boolean[] visited) {
        if (from == to) {
            return true;
        }

        if (memo[from][to] != null) {
            return memo[from][to];
        }

        visited[from] = true;
        List<Integer> nextList = adj[from];
        if (nextList == null) {
            memo[from][to] = false;
            return false;
        }

        for (Integer next : nextList) {
            if (visited[next]) {
                continue;
            }

            if (dfs(next, to, visited)) {
                memo[from][to] = true;
                return true;
            }
        }

        memo[from][to] = false;
        return false;
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] edges, int[][] queries) {
        List<Boolean> ansList = new ArrayList<>();

        adj = new ArrayList[n];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (adj[from] == null) {
                adj[from] = new ArrayList<>();
            }
            adj[from].add(to);
        }

        boolean[] visited = new boolean[n];
        memo = new Boolean[n][n];
        for (int[] query : queries) {
            int from = query[0];
            int to = query[1];
            Arrays.fill(visited, false);
            ansList.add(dfs(from, to, visited));
        }
        return ansList;
    }

}
