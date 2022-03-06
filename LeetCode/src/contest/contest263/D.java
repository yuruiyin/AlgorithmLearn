package contest.contest263;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/17
 */
public class D {

    private Set<Integer> edgeSet;

    private int getMinDis(Set<Integer>[] adj, int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        queue.add(1);
        int l = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            l++;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                Set<Integer> nextList = adj[node];
                for (int next : nextList) {
                    if (visited[next]) {
                        continue;
                    }
                    if (next == n) {
                        return l;
                    }
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return l;
    }

    private boolean hasExistMinDisPlusOne(Set<Integer>[] adj, int n) {
        for (int i = 1; i <= n; i++) {
            Set<Integer> nextSet = adj[i];
            List<Integer> nextList = new ArrayList<>(nextSet);
            int size = nextList.size();
            if (size >= 2) {
                for (int j = 0; j < size; j++) {
                    for (int k = j + 1; k < size; k++) {
                        if (edgeSet.contains(nextList.get(j) * 10001 + nextList.get(k))) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    private int getSecondMinDis(Set<Integer>[] adj, int n, int minDis) {
        boolean hasExistMinDisPlusOne = hasExistMinDisPlusOne(adj, n);
        if (hasExistMinDisPlusOne) {
            return minDis + 1;
        }
        return minDis + 2;
    }

    public int secondMinimum(int n, int[][] edges, int w, int change) {
        Set<Integer>[] adj = new HashSet[n + 1];
        edgeSet = new HashSet<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (adj[u] == null) {
                adj[u] = new HashSet<>();
            }
            adj[u].add(v);
            if (adj[v] == null) {
                adj[v] = new HashSet<>();
            }
            adj[v].add(u);

            edgeSet.add(u * 10001 + v);
            edgeSet.add(v * 10001 + u);
        }

        // 先求从节点1到n的最短路径
        int minDis = getMinDis(adj, n);
        int secondMinDis = getSecondMinDis(adj, n, minDis);

        int ans = 0;

        for (int i = 1; i <= secondMinDis; i++) {
            ans += w;
            if (i == secondMinDis) {
                break;
            }
            if ((ans / change) % 2 == 0) {
                // 绿灯
                continue;
            } else {
                // 红灯，需要等一会
                ans += change - ans % change;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
//        System.out.println(new D().secondMinimum(5, new int[][]{
//                {1,2},{1,3},{1,4},{3,4},{4,5}
//        } , 3, 5));
//
//        System.out.println(new D().secondMinimum(2, new int[][]{
//                {1,2}
//        } , 3, 2));

        System.out.println(new D().secondMinimum(6, new int[][]{
                {1,2},{1,3},{2,4},{3,5},{5,4},{4,6}
        } , 3, 100));
    }

}
