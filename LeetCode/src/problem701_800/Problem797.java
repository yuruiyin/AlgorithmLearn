package problem701_800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem797 {

    private List<Integer>[] adj;
    private int n;
    private List<List<Integer>> ansList;

    private void dfs(int cur, List<Integer> pathList) {
        if (cur == n - 1) {
            ansList.add(new ArrayList<>(pathList));
            return;
        }

        List<Integer> nextList = adj[cur];
        for (int next : nextList) {
            pathList.add(next);
            dfs(next, pathList);
            pathList.remove(pathList.size() - 1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ansList = new ArrayList<>();
        // 0 ~ n - 1的所有路径
        n = graph.length;
        adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int next: graph[i]) {
                adj[i].add(next);
            }
        }
        List<Integer> pathList = new ArrayList<>();
        pathList.add(0);
        dfs(0, pathList);
        return ansList;
    }

}
