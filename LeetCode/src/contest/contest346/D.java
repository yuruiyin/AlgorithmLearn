package contest.contest346;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class D {

    class Node {
        // 随便一个边权是-1的边
        int[] edge;
        int cost;

        int idx;
        Node(int[] edge, int cost, int idx) {
            this.edge = edge;
            this.cost = cost;
            this.idx = idx;
        }
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        if (n == 1) {
            return new int[][]{};
        }
        LinkedList<Node> queue = new LinkedList<>();
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        int[][][] map = new int[n][n][3];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
            map[u][v] = edge;
            map[v][u] = edge;
        }

        queue.add(new Node(null, 0, source));
        int[] minDis = new int[n];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        int[] targetEdge = null;
        boolean isOk = false;
        int offset = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean tmpIsOk = false;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.idx == destination) {
                    if (cur.cost == target) {
                        tmpIsOk = true;
                    } else if (cur.cost < target) {
                        if (cur.edge != null) {
                            tmpIsOk = true;
                            targetEdge = cur.edge;
                            offset = target - cur.cost;
                        } else {
                            return new int[][]{};
                        }
                    }
                    continue;
                }
                List<Integer> nextList = adj[cur.idx];
                for (int next: nextList) {
                    int[] edge = map[cur.idx][next];
                    Node nextNode = null;
                    if (minDis[next] == Integer.MAX_VALUE) {
                        int addCost = edge[2] == -1 ? 1 : edge[2];
                        int nextCost = cur.cost + addCost;
                        if (cur.edge != null) {
                            nextNode = new Node(cur.edge, nextCost, next);
                        } else {
                            nextNode = new Node(edge[2] == -1 ? edge : null, nextCost, next);
                        }
                        minDis[next] = nextCost;
                    } else {
                        int addCost = edge[2] == -1 ? 1 : edge[2];
                        int nextCost = cur.cost + addCost;
                        if (next == destination && (edge[2] != -1 && cur.edge == null) && nextCost < target) {
                            return new int[][]{};
                        }
                        if (nextCost < minDis[next]) {
                            if (cur.edge != null) {
                                nextNode = new Node(cur.edge, nextCost, next);
                            } else {
                                nextNode = new Node(edge[2] == -1 ? edge : null, nextCost, next);
                            }
                            minDis[next] = nextCost;
                        }
                    }

                    if (minDis[next] <= target && nextNode != null) {
                        queue.add(nextNode);
                    }
                }
            }
            if (tmpIsOk) {
                isOk = true;
            }
        }

        if (!isOk) {
            return new int[][]{};
        }

        for (int[] edge : edges) {
            if (edge == targetEdge) {
                edge[2] = 1;
                edge[2] += offset;
            } else {
                if (edge[2] == -1) {
                    edge[2] = 1;
                }
            }
        }
        return edges;
    }

}
