package problem701_800;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem743 {

    class Node {
        int id;
        int w;
        Node(int id, int w) {
            this.id = id;
            this.w = w;
        }
    }

    private int bfs(List<Node>[] adj, int n, int k) {
        LinkedList<Node> queue = new LinkedList<>();
        Node fromNode = new Node(k, 0);
        queue.add(fromNode);
        Node[] visited = new Node[n + 1];
        visited[k] = fromNode;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (adj[node.id] == null) {
                    continue;
                }
                for (Node next: adj[node.id]) {
                    if (visited[next.id] != null && node.w + next.w >= visited[next.id].w) {
                        continue;
                    }

                    Node newNode = new Node(next.id, node.w + next.w);
                    visited[next.id] = newNode;
                    queue.offer(newNode);
                }
            }
        }

        int ansMax = -1;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == null) {
                return -1;
            }

            if (i == k) {
                continue;
            }
            ansMax = Math.max(ansMax, visited[i].w);
        }

        return ansMax;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<Node>[] adj = new ArrayList[n + 1];

        for (int[] time: times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            if (adj[u] == null) {
                adj[u] = new ArrayList<>();
            }

            adj[u].add(new Node(v, w));
        }

        if (n == 1) {
            return 0;
        }

        return bfs(adj, n, k);
    }

}
