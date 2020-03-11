package contest.contest179;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem04 {

    class Node {
        int id;
        double p;
        Node(int id, double p) {
            this.id = id;
            this.p = p;
        }
    }

    private List<Integer>[] createAdj(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (adj[from] == null) {
                adj[from] = new ArrayList<>();
            }
            adj[from].add(to);

            if (adj[to] == null) {
                adj[to] = new ArrayList<>();
            }
            adj[to].add(from);
        }

        return adj;
    }

    private double bfs(int n, List<Integer>[] adj, int t, int target) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 1));
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                List<Integer> nextList = adj[node.id];
                if (node.id == target && (count == t || nextList == null)) {
                    return node.p;
                }

                if (nextList == null) {
                    continue;
                }

                int nextCount = 0;
                for (Integer next: nextList) {
                    if (!visited[next]) {
                        nextCount++;
                    }
                }

                if (node.id == target) {
                    if (nextCount == 0) {
                        return node.p;
                    } else { // 离开之后就不会再回到这个点了。因为它是一棵树
                        return 0;
                    }
                }

                for (Integer next : nextList) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.add(new Node(next, node.p / nextCount));
                }
            }

            count++;
            if (count > t) {
                return 0;
            }
        }

        return 0;
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] adj = createAdj(n, edges);
        return bfs(n, adj, t, target);
    }

}
