package doubleContest.round073;

import java.util.*;

public class C {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        int[] inDegree = new int[n];
        boolean[] visited = new boolean[n];
        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            adj[from].add(to);
            visited[from] = true;
            visited[to] = true;
            inDegree[to]++;
        }

        // 找入度为0的节点
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0 && visited[i]) {
                queue.add(i);
            }
        }

        List<TreeSet<Integer>> ansList1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ansList1.add(new TreeSet<>());
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                List<Integer> nextList = adj[cur];
                for (int next: nextList) {
                    ansList1.get(next).add(cur);
                    ansList1.get(next).addAll(ansList1.get(cur));
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            ansList.add(new ArrayList<>(ansList1.get(i)));
        }

        return ansList;
    }

}
