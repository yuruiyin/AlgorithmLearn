package problem501_600;

import dsu.TreeDSU;

public class Problem547 {

    /**
     * 用树实现的并查集
     * 每棵子树的parent都指向父亲子树
     * 与算法4里头介绍的区别在于我用的不是int数组，而是Tree数组。这种方式理论上更加高效
     * 同时，在每次寻找当前子树的root的时候，直接修改路径上所有节点的parent为root即可。
     *
     * @author: yry
     * @date: 2020/3/24
     */
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

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        TreeDSU dsu = new TreeDSU(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }
        return dsu.size();
    }

}
