package contest.contest418;

import java.util.*;

public class B {

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int[] inDegree = new int[n];
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge: invocations) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            inDegree[v]++;
        }

        Set<Integer> visited  = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(k);
        visited.add(k);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int top = queue.poll();
                List<Integer> nextList = adj[top];
                for (int next: nextList) {
                    inDegree[next]--;
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.add(next);
                }
            }
        }

        Set<Integer> removed = new HashSet<>();
        for (int node : visited) {
            if (inDegree[node] == 0) {
                removed.add(node);
            }
        }

        if (removed.size() != visited.size()) {
            removed.clear();
        }

//        if (removed.size() == 1 && removed.contains(k)) {
//            removed.clear();
//        }

        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (removed.contains(i)) {
                continue;
            }
            ansList.add(i);
        }
        return ansList;
    }

    public static void main(String[] args) {
        //  n = 5, k = 0, invocations = [[1,2],[0,2],[0,1],[3,4]]
        System.out.println(new B().remainingMethods(5, 0, new int[][]{
                {1,2},{0,2},{0,1},{3,4}
        }));
    }

}
