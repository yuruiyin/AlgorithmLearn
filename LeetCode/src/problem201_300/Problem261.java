package problem201_300;

import java.util.*;

public class Problem261 {

    private List<Integer>[] adj;
    private int n;

    /**
     * 思路：一张图是一颗树，必须满足就一个连通分支，并且边数比节点数少1，即edge = n - 1，也就是我们可以判断是否存在环，
     * 然后把边放到一个集合中，若不存在环，判断最后边数是否是节点数少1
     * 如果一条边未被访问过，并且边的另外一个节点被访问过，就说明图存在环，就不是一棵树。
     * @param nodeIndex 当前遍历到的节点index
     * @param nodeVisited 标记访问过的节点，用来判断是否存在环
     * @param edgeVisited 记录访问的边。
     * @return
     */
    private boolean isValid(int nodeIndex, boolean[] nodeVisited, Set<Long> edgeVisited) {
        nodeVisited[nodeIndex] = true;
        for (int neighbor: adj[nodeIndex]) {
            int minNode = Math.min(neighbor, nodeIndex);
            int maxNode = Math.max(neighbor, nodeIndex);
            long edge = n * minNode + maxNode;
            if (!edgeVisited.contains(edge)) {
                if (nodeVisited[neighbor]) {
                    return false;
                }

                edgeVisited.add(edge);
                boolean isLegal = isValid(neighbor, nodeVisited, edgeVisited);
                if (!isLegal) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];
            adj[first].add(second);
            adj[second].add(first);
        }

        Set<Long> edgeVisited = new HashSet<>();
        boolean isMatch = isValid(0, new boolean[n], edgeVisited);
        if (!isMatch) {
            return false;
        }

        return edgeVisited.size() == n - 1;
    }

}
