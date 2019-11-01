package problem1101_1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem1129 {

    private int[] ans;

    class Edge {
        int from;
        int to;
        boolean isRed;
        Edge(int from, int to, boolean isRed) {
            this.from = from;
            this.to = to;
            this.isRed = isRed;
        }
    }

    // dfs超时
    private void backTrack(ArrayList<Edge>[] adj, int from, boolean isRed, boolean[][][] visited, int level) {
        if (ans[from] != -1) {
            if (level < ans[from]) {
                ans[from] = level;
            }
        } else {
            ans[from] = level;
        }

        for (Edge edge: adj[from]) {
            int nextNode = edge.to;
            boolean curIsRed = edge.isRed;
            if (from != 0 && curIsRed != isRed) {
                continue;
            }

            if (visited[from][nextNode][curIsRed ? 1 : 0]) {
                continue;
            }

            visited[from][nextNode][curIsRed ? 1 : 0] = true;
            backTrack(adj, nextNode, !curIsRed, visited, level + 1);
            visited[from][nextNode][curIsRed ? 1 : 0] = false;
        }
    }

    class Node {
        int id;
        boolean isFromRed;
        Node(int id, boolean isFromRed) {
            this.id = id;
            this.isFromRed = isFromRed;
        }
    }

    private void bfs(ArrayList<Edge>[] adj) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(new Node(0, true));
        queue.addLast(new Node(0, false));
        boolean[][][] edgeVisited = new boolean[100][100][2];

        int level = 0;

        while (!queue.isEmpty()) {
            List<Node> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.removeFirst());
            }

            level++;

            for (Node node : nodeList) {
                for (Edge edge: adj[node.id]) {
                    if (edge.isRed == node.isFromRed || edgeVisited[edge.from][edge.to][edge.isRed ? 0 : 1]) {
                        continue;
                    }
                    edgeVisited[edge.from][edge.to][edge.isRed ? 0 : 1] = true;
                    queue.addLast(new Node(edge.to, edge.isRed));
                    if (ans[edge.to] != -1) {
                        if (level < ans[edge.to]) {
                            ans[edge.to] = level;
                        }
                    } else {
                        ans[edge.to] = level;
                    }
                }
            }
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        ArrayList<Edge>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] red_edge : red_edges) {
            int node1 = red_edge[0];
            int node2 = red_edge[1];
            adj[node1].add(new Edge(node1, node2, true));
        }

        for (int[] blue_edge : blue_edges) {
            int node1 = blue_edge[0];
            int node2 = blue_edge[1];
            adj[node1].add(new Edge(node1, node2, false));
        }

        ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;
//        backTrack(adj, 0, false, new boolean[100][100][2], 0);
        bfs(adj);
        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}

//示例 1：
//
//        输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
//        输出：[0,1,-1]
//        示例 2：
//
//        输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
//        输出：[0,1,-1]
//        示例 3：
//
//        输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
//        输出：[0,-1,-1]
//        示例 4：
//
//        输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
//        输出：[0,1,2]
//        示例 5：
//
//        输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
//        输出：[0,1,1]


//         3
//        [[0,1],[1,2]]
//        []
//        3
//        [[0,1]]
//        [[2,1]]
//        3
//        [[1,0]]
//        [[2,1]]
//        3
//        [[0,1]]
//        [[1,2]]
//        3
//        [[0,1],[0,2]]
//        [[1,0]]
//        5
//        [[2,2],[0,1],[0,3],[0,0],[0,4],[2,1],[2,0],[1,4],[3,4]]
//        [[1,3],[0,0],[0,3],[4,2],[1,0]]
//        5
//        [[0,1],[1,2],[2,3],[3,4]]
//        [[1,2],[2,3],[3,1]]
