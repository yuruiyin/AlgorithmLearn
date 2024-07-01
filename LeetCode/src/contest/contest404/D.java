package contest.contest404;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class D {

    static class TreeDiameter {
        private int ansMax;
        private int n;

        private int bfs(ArrayList<Integer>[] adj, int from) {
            LinkedList<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];

            queue.addLast(from);
            visited[from] = true;

            int deepestNode = from;

            int len = 0;
            while (!queue.isEmpty()) {
                List<Integer> nodeList = new ArrayList<>();
                while (!queue.isEmpty()) {
                    nodeList.add(queue.removeFirst());
                }

                len++;
                deepestNode = nodeList.get(0);

                for (Integer node: nodeList) {
                    for (Integer next: adj[node]) {
                        if (visited[next]) {
                            continue;
                        }

                        queue.addLast(next);
                        visited[next] = true;
                    }
                }
            }

            len--;
            if (len > ansMax) {
                ansMax = len;
            }

            return deepestNode;
        }

        public int calcTreeDiameter(int[][] edges) {
            ansMax = 0;
            int n = edges.length;
            this.n = n;
            if (n == 0 || n == 1) {
                return n;
            }

            ArrayList<Integer>[] adj = new ArrayList[n + 1];

            for (int i = 0; i < n + 1; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }

            int deepest = bfs(adj, 0);
            bfs(adj, deepest);

            return ansMax;
        }
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        TreeDiameter treeDiameter = new TreeDiameter();
        int treeDiameter1 = treeDiameter.calcTreeDiameter(edges1);
        int treeDiameter2 = treeDiameter.calcTreeDiameter(edges2);
        int mid1 = (treeDiameter1 + 1) / 2;
        int mid2 = (treeDiameter2 + 1) / 2;
        return Math.max(Math.max(treeDiameter1, treeDiameter2), mid1 + mid2 + 1);
    }

}
