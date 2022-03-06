package contest.contest264;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/24
 */
public class D {

    private List<Integer>[] parentAdj;
    private int[] time;
    private int[] memo;

    private int dfs(int cur) {
        List<Integer> parentList = parentAdj[cur];
        if (parentList == null) {
            return time[cur - 1];
        }

        if (memo[cur] != -1) {
            return memo[cur];
        }

        int max = 0;
        for (int parent : parentList) {
            max = Math.max(max, dfs(parent));
        }
        memo[cur] = max + time[cur - 1];
        return memo[cur];
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];
        this.time = time;
        parentAdj = new ArrayList[n + 1];
        for (int[] edge : relations) {
            int from = edge[0];
            int to = edge[1];
            inDegree[to]++;
            outDegree[from]++;
            if (parentAdj[to] == null) {
                parentAdj[to] = new ArrayList<>();
            }
            parentAdj[to].add(from);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (outDegree[i] == 0) {
                queue.add(i);
            }
        }

        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        int ansMax = 0;
        for (int node : queue) {
            ansMax = Math.max(ansMax, dfs(node));
        }

        return ansMax;
    }

}
