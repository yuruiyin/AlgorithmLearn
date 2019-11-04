package problem1201_1300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem1245 {

    private int ansMax = 0;
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

    public int treeDiameter(int[][] edges) {
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
    
    public static void main(String[] args) {
        
    }
    
}
