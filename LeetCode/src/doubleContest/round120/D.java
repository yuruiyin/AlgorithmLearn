package doubleContest.round120;

import java.util.*;

public class D {

    class Result {
        List<Long> negList;
        List<Long> posList;

        Result(List<Long> negList, List<Long> posList) {
            this.negList = negList;
            this.posList = posList;
        }
    }

    private int[] countArr;
    private long[] ans;

    private Result dfs(int cur, List<Integer>[] adj, boolean[] visited, int[] cost) {
        visited[cur] = true;
        List<Integer> nextList = adj[cur];
        List<Long> negList = new ArrayList<>();
        List<Long> posList = new ArrayList<>();
        if (cost[cur] < 0) {
            negList.add((long) cost[cur]);
        } else {
            posList.add((long) cost[cur]);
        }
        for (int next: nextList) {
            if (visited[next]) {
                continue;
            }
            Result tmpRes = dfs(next, adj, visited, cost);
            List<Long> tmpNegList = tmpRes.negList;
            List<Long> tmpPosList = tmpRes.posList;
            List<Long> mergeNegList = new ArrayList<>(tmpNegList);
            mergeNegList.addAll(negList);
            Collections.sort(mergeNegList);
            if (!mergeNegList.isEmpty()) {
                negList = mergeNegList.subList(0, Math.min(3, mergeNegList.size()));
            }

            List<Long> mergePosList = new ArrayList<>(tmpPosList);
            mergePosList.addAll(posList);
            mergePosList.sort((o1, o2) -> Long.compare(o2, o1));
            if (!mergePosList.isEmpty()) {
                posList = mergePosList.subList(0, Math.min(3, mergePosList.size()));
            }
        }

        long value = 0;
        if (posList.size() == 3) {
            value = posList.get(0) * posList.get(1) * posList.get(2);
        }

        if (negList.size() >= 2 && posList.size() >= 1) {
            value = Math.max(value, negList.get(0) * negList.get(1) * posList.get(0));
        }

        ans[cur] = countArr[cur] < 3 ? 1 : value;
        return new Result(negList, posList);
    }

    private int dfsCount(int cur, List<Integer>[] adj, boolean[] visited) {
        visited[cur] = true;
        List<Integer> nextList = adj[cur];
        int count = 1;
        for (int next: nextList) {
            if (visited[next]) {
                continue;
            }
            count += dfsCount(next, adj, visited);
        }
        countArr[cur] = count;
        return count;
    }

    public long[] placedCoins(int[][] edges, int[] cost) {
        int n = edges.length + 1;
        if (n <= 2) {
            long[] ans = new long[n];
            Arrays.fill(ans, 1);
            return ans;
        }

        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        countArr = new int[n];
        dfsCount(0, adj, new boolean[n]);
        ans = new long[n];
        dfs(0, adj, new boolean[n], cost);
        return ans;
    }

}
