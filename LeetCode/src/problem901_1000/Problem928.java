package problem901_1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem928 {

    private int len;

    private int getInfectCount(List<Integer>[] adj, int removeInfectNode, int[] initial) {
        boolean[] visited = new boolean[len];
        int infectedCount = 0;
        for (int infectNode : initial) {
            if (visited[infectNode] || infectNode == removeInfectNode) {
                continue;
            }

            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(infectNode);
            visited[infectNode] = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int node = queue.poll();
                    infectedCount++;
                    for (Integer next: adj[node]) {
                        if (visited[next] || next == removeInfectNode) {
                            continue;
                        }

                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        return infectedCount;
    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        len = graph.length;
        List<Integer>[] adj = new ArrayList[len];

        for (int i = 0; i < len; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j || graph[i][j] == 0) {
                    continue;
                }

                adj[i].add(j);
                adj[j].add(i);
            }
        }

        // BFS求出删除某个节点的污染节点数
        Arrays.sort(initial);
        int minInfectedCount = Integer.MAX_VALUE;
        int ansRemoveNode = -1;
        for (int infectNode : initial) {
            int infectCount = getInfectCount(adj, infectNode, initial);
            if (infectCount < minInfectedCount) {
                minInfectedCount = infectCount;
                ansRemoveNode = infectNode;
            }
        }

        return ansRemoveNode;
    }

}
