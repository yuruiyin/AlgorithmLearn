package contest.contest205;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/6
 */
public class D {

    static class TreeDSU {

        /**
         * 每棵树存放节点数，两个已有的树进行合并的时候，应该让节点少的的那棵树合并到节点多的那棵上
         * (即节点少的那棵树的parent指向节点多的那棵树）。这样能够保证每棵树的最大高度不会超过logn
         * （理论上会小于logn，因为这里的节点其实是一个集合，不是数据结构中的集合，而是就占用O(1)时间复杂度的包含了多个真实节点的对象）。
         * 同时，当两颗高度一样的树merge的时候，我们需要不断更新树的节点数。
         */
        private static class Tree {
            // 父节点
            private Tree parent;
            // 存放以当前树为根的子树中的节点数
            private int count = 1;
        }

        private Tree[] trees;
        private int size;

        public TreeDSU(int n) {
            trees = new Tree[n];
            size = n;
        }

        /**
         * 寻找当前树的根节点，同时修改路径中每棵子树的parent为根节点
         */
        private Tree root(Tree tree) {
            return tree.parent == null ? tree : (tree.parent = root(tree.parent)); // 即算法4里头提到的路径压缩
        }

        private void mergeTree(Tree root1, Tree root2) {
            root2.parent = root1;
            root1.count += root2.count;
        }

        public boolean union(int node1, int node2) {
            Tree tree1 = trees[node1];
            Tree tree2 = trees[node2];

            if (tree1 != null && tree2 != null) {
                if (tree1 == tree2) {
                    return false; // 两个节点已经在一颗树中了
                }

                Tree root1 = root(tree1);
                Tree root2 = root(tree2);
                if (root1 == root2) {
                    return false;
                }

                if (root1.count <= root2.count) {
                    // root1合并到root2中
                    mergeTree(root2, root1);
                } else {
                    // root2合并到root1中
                    mergeTree(root1, root2);
                }
            } else if (tree1 != null) {
                // tree2 == null
                trees[node2] = tree1;
            } else if (tree2 != null) {
                trees[node1] = tree2;
            } else {
                Tree tree = new Tree();
                trees[node1] = tree;
                trees[node2] = tree;
            }

            size--;
            return true;
        }

        public boolean connected(int x, int y) {
            if (x == y) {
                return true;
            }

            if (trees[x] == null || trees[y] == null) {
                return false;
            }

            return root(trees[x]) == root(trees[y]);
        }

        /**
         * 连通分量的个数
         */
        public int size() {
            return size;
        }

    }

    private static final int MAX = 100001;

    private int[] getAns(int n, int edgeCount, int[][] edges, int curType, boolean[] removeEdgeArr) {
        boolean[] visited = new boolean[n + 1];
        int edgeCount1 = 0;
        int[] inDegree = new int[n + 1];
        for (int i = 0; i < edgeCount; i++) {
            int[] edge = edges[i];
            int type = edge[0];
            int v1 = edge[1];
            int v2 = edge[2];
            if ((type == curType || type == 3) && !removeEdgeArr[i]) {
                edgeCount1++;
                visited[v1] = true;
                visited[v2] = true;
                inDegree[v1]++;
                inDegree[v2]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return null;
            }
        }

        int totalNeedRemoveEdgeCount = edgeCount1 - (n - 1);
        int removeBlueEdgeCount = 0;

        TreeDSU dsu = new TreeDSU(n);

        for (int i = 0; i < edgeCount; i++) {
            int[] edge = edges[i];
            int type = edge[0];
            int v1 = edge[1];
            int v2 = edge[2];
            if (type == 3 && !removeEdgeArr[i]) {
                if (!dsu.union(v1 - 1, v2 - 1)) {
                    removeBlueEdgeCount++;
                }
            }
        }

        return new int[]{totalNeedRemoveEdgeCount, removeBlueEdgeCount};
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int edgeCount = edges.length;

        Set<Long> set3 = new HashSet<>();

        for (int[] edge : edges) {
            int type = edge[0];
            int v1 = edge[1];
            int v2 = edge[2];
            if (type == 3) {
                set3.add((long)v1 * MAX + v2);
            }
        }

        boolean[] removeEdgeArr = new boolean[edgeCount];
        int removeCount = 0;
        for (int i = 0; i < edgeCount; i++) {
            int[] edge = edges[i];
            int type = edge[0];
            int v1 = edge[1];
            int v2 = edge[2];
            long key = (long)v1 * MAX + v2;
            if (type != 3 && set3.contains(key)) {
                removeEdgeArr[i] = true;
                removeCount++;
            }
        }

        int[] ans1 = getAns(n, edgeCount, edges, 1, removeEdgeArr);
        int[] ans2 = getAns(n, edgeCount, edges, 2, removeEdgeArr);

        if (ans1 == null || ans2 == null) {
            return -1;
        }

        return ans1[0] + ans2[0] + removeCount - ans1[1];
    }

}
