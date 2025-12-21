package contest.contest481;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D {

    private List<Integer>[] adj;
    private long ans;

    // 每个分支的节点数
    private int[] totalCountArr;

    private int[] group;

    private int[] dfs(int cur, int par) {
        int[] res = new int[21];
        res[group[cur]] = 1;
        for (int next: adj[cur]) {
            if (next == par) {
                continue;
            }

            int[] tmpRes = dfs(next, cur);

            for (int i = 1; i <= 20; i++) {
                ans += (long)tmpRes[i] * (totalCountArr[i] - tmpRes[i]);
                res[i] += tmpRes[i];
            }
        }

        return res;
    }

    public long interactionCosts(int n, int[][] edges, int[] group) {
        this.adj = new ArrayList[n];
        this.group = group;
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] e: edges) {
            int u = e[0];
            int v = e[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        this.ans = 0;
        this.totalCountArr = new int[21];
        for (int g : group) {
            totalCountArr[g]++;
        }

        dfs(0, -1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
