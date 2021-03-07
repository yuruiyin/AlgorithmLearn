package contest.contest223;

import dsu.TreeDSU;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/10
 */
public class C {

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


    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        // 并查集
        int n = source.length;
        Set<Integer> swapIdxSet = new HashSet<>();
        TreeDSU treeDSU = new TreeDSU(n);
        for (int[] swap : allowedSwaps) {
            treeDSU.union(swap[0], swap[1]);
        }

        // 求所有的root
        Map<TreeDSU.Tree, Set<Integer>> indexListMap = new HashMap<>();
        for (int[] swap : allowedSwaps) {
            int i1 = swap[0];
            int i2 = swap[1];
            swapIdxSet.add(i1);
            swapIdxSet.add(i2);
            TreeDSU.Tree root1 = treeDSU.root(treeDSU.trees[i1]);
            TreeDSU.Tree root2 = treeDSU.root(treeDSU.trees[i2]);
            if (!indexListMap.containsKey(root1)) {
                indexListMap.put(root1, new HashSet<>());
            }
            indexListMap.get(root1).add(i1);
            if (!indexListMap.containsKey(root2)) {
                indexListMap.put(root2, new HashSet<>());
            }
            indexListMap.get(root2).add(i2);
        }

        int ans = 0;
        for (TreeDSU.Tree root : indexListMap.keySet()) {
            Map<Integer, Integer> valueCountMap = new HashMap<>();
            Set<Integer> indexList = indexListMap.get(root);
            for (int idx : indexList) {
                valueCountMap.put(source[idx], valueCountMap.getOrDefault(source[idx], 0) + 1);
            }
            int diffCount = indexList.size();
            for (int idx : indexList) {
                int count = valueCountMap.getOrDefault(target[idx], 0);
                if (count > 0) {
                    diffCount--;
                    valueCountMap.put(target[idx], count - 1);
                }
            }
            ans += diffCount;
        }

        for (int i = 0; i < n; i++) {
            if (!swapIdxSet.contains(i)) {
                if (source[i] != target[i]) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
