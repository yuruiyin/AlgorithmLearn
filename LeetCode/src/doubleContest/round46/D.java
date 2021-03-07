package doubleContest.round46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/20
 */
public class D {

    private int[] parent;
    private List<Integer>[] adj;
    private int n;

    private void dfs(int from, boolean[] visited) {
        visited[from] = true;
        List<Integer> nextList = adj[from];
        for (int next : nextList) {
            if (visited[next]) {
                continue;
            }

            parent[next] = from;
            dfs(next, visited);
        }
    }

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        n = nums.length;
        parent = new int[n];
        adj = new ArrayList[n];
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

        // 求parent数组
        dfs(0, new boolean[n]);

        parent[0] = -1;

        int[] ansArr = new int[n];
        Arrays.fill(ansArr, -1);

        List<Integer>[] indexListArr = new ArrayList[51];
        for (int i = 0; i < n; i++) {
            if (indexListArr[nums[i]] == null) {
                indexListArr[nums[i]] = new ArrayList<>();
            }
            indexListArr[nums[i]].add(i);
        }

        for (int i = 1; i <= 50; i++) {
            if (indexListArr[i] == null) {
                continue;
            }

            List<Integer> indexList = indexListArr[i];
            int[] beVisitedIdxArr = new int[n];
            Arrays.fill(beVisitedIdxArr, -1);
            for (int idx : indexList) {
                if (beVisitedIdxArr[idx] != -1) {
                    ansArr[idx] = ansArr[beVisitedIdxArr[idx]];
                    continue;
                }

                int cur = idx;
                while (parent[cur] != -1) {
                    if (beVisitedIdxArr[parent[cur]] == -1) {
                        beVisitedIdxArr[parent[cur]] = idx;
                    }

                    if (gcd(nums[idx], nums[parent[cur]]) == 1) {
                        ansArr[idx] = parent[cur];
                        break;
                    }
                    cur = parent[cur];
                }
            }
        }

        return ansArr;
    }

}
