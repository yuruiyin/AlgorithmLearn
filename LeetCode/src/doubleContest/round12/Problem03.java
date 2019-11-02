package doubleContest.round12;

import sun.security.x509.IssuerAlternativeNameExtension;

import java.util.*;

public class Problem03 {

    private int ansMax = 0;
    private int n;

    private int[] memo;

    private int dfs(ArrayList<Integer>[] adj, int from, boolean[] visited) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (Integer next: adj[from]) {
            if (visited[next]) {
                continue;
            }

            visited[next] = true;
            int res = dfs(adj, next, visited);
            visited[next] = false;
            queue.add(res);
            if (queue.size() > 2) {
                queue.poll();
            }
        }

        if (queue.isEmpty()) {
            // 叶子
            return 0;
        }

        if (queue.size() == 1) {
            int len = queue.peek() + 1;
            if (len > ansMax) {
                ansMax = len;
            }
            return len;
        }

        int first = queue.poll();
        int second = queue.poll();
        int len = first + second + 2;
        if (len > ansMax) {
            ansMax = len;
        }
        return Math.max(first, second) + 1;
    }

    private void bfs(ArrayList<Integer>[] adj, int from) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.addLast(from);
        visited[from] = true;

        int len = 0;
        while (!queue.isEmpty()) {
            List<Integer> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.removeFirst());
            }

            len++;

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

        memo = new int[n + 1];

//        for (int i = 0; i <= n; i++) {
//            if (adj[i].size() >= 2) {
//                continue;
//            }
////            bfs(adj, i);
//        }
        dfs(adj, 0, new boolean[n+1]);

        return ansMax;
    }
    
    public static void main(String[] args) {
        
    }
    
}
