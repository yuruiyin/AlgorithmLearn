package contest.contest2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem07 {

    private int[][] cost;
    private List<Integer>[] adj;
    private String[] codes;
    private int n;

    class Node {
        int id;
        long pathLen;
        String codeSet;
        Node(int id, long pathLen, String codeSet) {
            this.id = id;
            this.pathLen = pathLen;
            this.codeSet = codeSet;
        }
    }

    private String bfs() {
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(new Node(11, 0, codes[11]));

        Node[] visited = new Node[n];
        visited[11] = new Node(11, 0, codes[11]);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                List<Integer> neighbors = adj[node.id];
                for (Integer next: neighbors) {
                    int minCost = Math.min(cost[node.id][next], cost[next][node.id]);
                    if (visited[next] != null && visited[next].pathLen <= node.pathLen + minCost) {
                        continue;
                    }

                    if (visited[next] == null) {
                        visited[next] = new Node(next, node.pathLen + minCost, node.codeSet + codes[next]);
                    } else {
                        visited[next].pathLen = node.pathLen + minCost;
                        visited[next].codeSet = node.codeSet + codes[next];
                    }

                    queue.offer(visited[next]);
                }
            }
        }

        return visited[0].codeSet;
    }

    public String happy(int n, int[][] roads, String[] codes) {
        this.n = n;
        this.codes = codes;
        adj = new ArrayList[n];
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        for (int[] road : roads) {
            int node1 = road[0];
            int node2 = road[1];
            if (node1 == node2) {
                continue;
            }

            int w = road[2];

            if (adj[node1] == null) {
                adj[node1] = new ArrayList<>();
            }

            cost[node1][node2] = Math.min(cost[node1][node2], w);
            adj[node1].add(node2);

            if (adj[node2] == null) {
                adj[node2] = new ArrayList<>();
            }

            cost[node2][node1] = Math.min(cost[node2][node1], w);
            adj[node2].add(node1);
        }

//        return "http://www.youtube.com/watch?v=dQw4w9WgXcQ&realanswer=aHR0cHM6Ly9temwubGEvMk53RnA1Wg==";
        return bfs();
    }

}
