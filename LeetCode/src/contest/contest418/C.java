package contest.contest418;

import java.util.*;

public class C {

    // 一行
    private int[][] getAns1(List<Integer>[] adj, int from, int n) {
        int[][] ansGrid = new int[1][n];
        ansGrid[0][0] = from;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(from);
        boolean[] visited = new boolean[n];
        visited[from] = true;
        int idx = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int top = queue.poll();
                List<Integer> nextList = adj[top];
                for (int next : nextList) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.add(next);
                    ansGrid[0][idx++] = next;
                }
            }
        }
        return ansGrid;
    }

    private int getGridSide(List<Integer>[] adj, int degree3Node, Set<Integer> degree2Set, Set<Integer> degree3Set, int fromDegree2) {
        Set<Integer> visited = new HashSet<>();
        visited.add(degree3Node);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(degree3Node);
        int sideLen = 2;
        while (!queue.isEmpty()) {
            int top = queue.poll();
            List<Integer> nextList = adj[top];
            for (int next: nextList) {
                if (next == fromDegree2) {
                    continue;
                }
                if (degree2Set.contains(next)) {
                    return sideLen;
                }
                if (visited.contains(next) || !degree3Set.contains(next)) {
                    continue;
                }
                visited.add(next);
                queue.add(next);
            }
            sideLen++;
         }
        return sideLen;
    }

    class Node {
        int row;
        int col;
        int val;
        Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int[][] constructGridLayout(int n, int[][] edges) {
        int[] degree = new int[n];
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
            degree[u]++;
            degree[v]++;
        }

        Set<Integer> degree2Set = new HashSet<>();
        Set<Integer> degree3Set = new HashSet<>();
        Set<Integer> degree4Set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                return getAns1(adj, i, n);
            }
            if (degree[i] == 2) {
                degree2Set.add(i);
            } else if (degree[i] == 3) {
                degree3Set.add(i);
            } else if (degree[i] == 4) {
                degree4Set.add(i);
            }
        }

        // 度为2的节点为4个
        int degree2Node = degree2Set.iterator().next();
        int[] sides = new int[2];
        for (int i = 0; i < 2; i++) {
            int degree3Node = adj[degree2Node].get(i);
            sides[i] = getGridSide(adj, degree3Node, degree2Set, degree3Set, degree2Node);
        }

        int rowCount = sides[0];
        int colCount = sides[1];
        int[][] ansGrid = new int[rowCount][colCount];

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, degree2Node));
        boolean[] visited = new boolean[degree2Node];
        ansGrid[0][0] = degree2Node;
        visited[degree2Node] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node top = queue.poll();
                List<Integer> nextList = adj[top.val];
                for (int next : nextList) {
                    if (visited[next]) {
                        continue;
                    }

                    

                }
            }
        }

        // todo

        return null;
    }

}
