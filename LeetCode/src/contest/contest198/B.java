package contest.contest198;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/19
 */
public class B {

    private List<Integer>[] adj;
    private char[] labelArr;
    private boolean[] visited;
    private int[] ans;

    private int[] dfs(int cur) {
        visited[cur] = true;
        List<Integer> nextList = adj[cur];
        if (nextList == null) {
            int[] arr = new int[26];
            arr[labelArr[cur] - 'a'] = 1;
            ans[cur] = 1;
            return arr;
        }

        int[] res = new int[26];
        res[labelArr[cur] - 'a'] = 1;
        for (Integer next : nextList) {
            if (visited[next]) {
                continue;
            }

            int[] tmpRes = dfs(next);
            for (int i = 0; i < 26; i++) {
                res[i] += tmpRes[i];
            }
        }

        ans[cur] = res[labelArr[cur] - 'a'];
        return res;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        adj = new ArrayList[n];
        labelArr = labels.toCharArray();
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

        visited = new boolean[n];
        ans = new int[n];
        dfs(0);
        return ans;
    }

}
