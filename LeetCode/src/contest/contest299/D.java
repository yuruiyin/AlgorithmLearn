package contest.contest299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class D {

    private int sumXor;

    private List<Integer>[] adj;

    private int[] nums;
    private int n;

    private int[] xorArr;

    private int ansMin;

    private Map<Integer, Integer> map;

    private int dfs(int cur, int parent, boolean[] visited) {
        List<Integer> nextList = adj[cur];
        int ans = nums[cur];
        visited[cur] = true;
        for (int next : nextList) {
            if (visited[next]) {
                continue;
            }
            int res = dfs(next, cur, visited);
            ans ^= res;
        }
        map.put(parent * 1001 + cur, ans);
        return ans;
    }

    private int[][] memo;

    class Result {
        int minXor;
        int maxXor;
        Result(int minXor, int maxXor) {
            this.minXor = minXor;
            this.maxXor = maxXor;
        }
    }

    private Result dfs1(int cur, boolean[] visited) {
        List<Integer> nextList = adj[cur];
        int xor = nums[cur];
        visited[cur] = true;
        Result result = new Result(Integer.MAX_VALUE, 0);
        for (int next: nextList) {
            if (visited[next]) {
                continue;
            }
            Result temRes = dfs1(next, visited);
            int left = sumXor ^ temRes.maxXor ^ temRes.minXor;
            int max = Math.max(left, temRes.maxXor);
            int min = Math.min(left, temRes.minXor);
            result.maxXor = Math.max(result.maxXor, max);
            result.minXor = Math.min(result.minXor, min);
        }
        ansMin = Math.min(ansMin,  result.maxXor - result.minXor);
        return result;
    }

    public int minimumScore(int[] nums, int[][] edges) {
        sumXor = 0;
        this.n = nums.length;
        this.nums = nums;
        for (int num : nums) {
            sumXor ^= num;
        }

        adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        xorArr = new int[n];
        dfs(0, -1, new boolean[n]);
        ansMin = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            for (int j = 0; j < edges.length; j++) {

            }
        }
        return 0;
    }

}
