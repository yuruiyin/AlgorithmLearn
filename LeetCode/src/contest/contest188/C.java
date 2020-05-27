package contest.contest188;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/10
 */
public class C {

    private List<Integer>[] adj;
    private List<Boolean> hasApple;
    private int n;

    class Result {
        int count;
        boolean hasApp;

        Result(int count, boolean hasApp) {
            this.count = count;
            this.hasApp = hasApp;
        }
    }

    private Result dfs(int cur, boolean[] visited) {
        List<Integer> nextList = adj[cur];
        visited[cur] = true;
        boolean ansHasApple = hasApple.get(cur);
        int ansCount = 0;
        for (Integer next : nextList) {
            if (visited[next]) {
                continue;
            }

            Result childRes = dfs(next, visited);
            if (childRes.hasApp) {
                ansHasApple = true;
                ansCount += childRes.count + 2;
            }
        }

        return new Result(ansCount, ansHasApple);
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        adj = new ArrayList[n];
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            if (adj[v1] == null) {
                adj[v1] = new ArrayList<>();
            }
            adj[v1].add(v2);

            if (adj[v2] == null) {
                adj[v2] = new ArrayList<>();
            }
            adj[v2].add(v1);
        }

        this.hasApple = hasApple;
        this.n = n;

        Result result = dfs(0, new boolean[n]);
        return result.count;
    }

}
