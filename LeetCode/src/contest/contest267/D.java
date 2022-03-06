package contest.contest267;

import dsu.TreeDSU;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/11/14
 */
public class D {

    public static class TreeDSU {

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

        public boolean exist(int x) {
            return trees[x] != null;
        }

        /**
         * 连通分量的个数
         */
        public int size() {
            return size;
        }

    }

    private boolean isOk(List<Integer> list1, List<Integer> list2, boolean[][] rest) {
        for (int ii = 0; ii < list1.size(); ii++) {
            for (int jj = 0; jj < list2.size(); jj++) {
                if (rest[list1.get(ii)][list2.get(jj)]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        boolean[][] rest = new boolean[n][n];
        for (int[] arr : restrictions) {
            int u = arr[0];
            int v = arr[1];
            rest[u][v] = true;
            rest[v][u] = true;
        }

        TreeDSU dsu = new TreeDSU(n);
        boolean[] ansArr = new boolean[requests.length];
        for (int i = 0; i < requests.length; i++) {
            int[] request = requests[i];
            int u = request[0];
            int v = request[1];
            if (rest[u][v]) {
                ansArr[i] = false;
                continue;
            }

            if (dsu.connected(u, v)) {
                ansArr[i] = true;
                continue;
            }

            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            list1.add(u);
            list2.add(v);
            for (int j = 0; j < n; j++) {
                if (j != u && dsu.connected(j, u)) {
                    list1.add(j);
                }
                if (j != v && dsu.connected(j, v)) {
                    list2.add(j);
                }
            }

            if (isOk(list1, list2, rest)) {
                dsu.union(u, v);
                ansArr[i] = true;
            } else {
                ansArr[i] = false;
            }

        }
        return ansArr;
    }

    public static void main(String[] args) {
        boolean[] ansArr = new D().friendRequests(8, new int[][]{{6,4},{7,5},{2,6},{1,5},{6,7},{6,5},{0,3},{5,4},{0,4},{2,7},{0,2}},
                new int[][]{{6,3},{0,2},{0,5},{0,3},{6,4},{2,4},{1,0},{2,1},{2,5},{6,7},{7,0},{3,2},{3,5},{2,1},{1,6},{7,4},{6,3},{1,3},{6,5},{3,7},{7,0},{6,5},{0,5},{0,4},{7,5},{7,0},{7,0},{1,3}});
    }

}
