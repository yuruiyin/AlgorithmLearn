package problem201_300;

import dsu.LinkDSU;

public class Problem261_2 {

    // 并查集，遍历每条边，判断边的两个顶点是否已经存在于同一颗树中，若是，则加入这条边会生成环。
    // 若后面无环，则判断最终并到一棵树的节点数是否等于n，如果是，则说明所有节点都并到了一棵树上，也就是说就一个联通分支，也就是说明这张图就是一棵树
    public boolean validTree(int n, int[][] edges) {
        LinkDSU dsu = new LinkDSU(n);

        if (edges.length == 0) {
            return n == 1;
        }

        for (int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            if (!dsu.union(node1, node2)) {
                // 存在环
                return false;
            }
        }

        return dsu.size() == 1;
    }

}
