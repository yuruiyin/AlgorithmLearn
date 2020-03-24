package dsu;

/**
 * 用链表实现的并查集
 *
 * @author: yry
 * @date: 2020/3/23
 */
public class LinkDSU {

    /**
     * 用链表来表示并查集中的树
     */
    static class Tree {
        private int size;
        private Node first;
        private Node last;

        public Tree(int value1, int value2) {
            Node node1 = new Node(value1);
            Node node2 = new Node(value2);
            node1.next = node2;
            first = node1;
            last = node2;
            size = 2;
        }

        public void add(int value) {
            Node newNode = new Node(value);
            if (last == null) {
                last = newNode;
                first = newNode;
            } else {
                last.next = newNode;
                last = last.next;
            }

            size++;
        }

        /**
         * 把一个链表加入到当前链表尾部，并更新合并后的新链表的头和尾
         */
        public void addAll(Tree tree) {
            if (last == null) {
                first = tree.first;
                last = tree.last;
            } else {
                last.next = tree.first;
                last = tree.last;
            }

            size += tree.size;
        }

        public int size() {
            return size;
        }

        static class Node {
            int val;
            Node next;
            Node(int val) {
                this.val = val;
            }
        }

    }

    private Tree[] trees;
    private int size;

    public LinkDSU(int n) {
        this.trees = new Tree[n];
        size = n;
    }

    /**
     *  from 合并到 to
     */
    private void doUnion(Tree from, Tree to) {
        // tree1合并到tree2中
        to.addAll(from);
        Tree.Node cur = from.first;
        while (cur != null) {
            trees[cur.val] = to;
            cur = cur.next;
        }
    }

    public boolean union(int node1, int node2) {
        Tree tree1 = trees[node1];
        Tree tree2 = trees[node2];

        if (tree1 != null && tree2 != null) {
            if (tree1 == tree2) {
                return false; // 两个节点已经在一颗树中了
            }

            // 小树往大树合并，开销小
            if (tree1.size() < tree2.size()) {
                // tree1合并到tree2中
                doUnion(tree1, tree2);
            } else {
                // tree2合并到tree1中
                doUnion(tree2, tree1);
            }
        } else if (tree1 != null) {
            // tree2 == null
            tree1.add(node2);
            trees[node2] = tree1;
        } else if (tree2 != null) {
            tree2.add(node1);
            trees[node1] = tree2;
        } else {
            Tree tree = new Tree(node1, node2);
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
        return trees[x] == trees[y];
    }

    /**
     * 获取连通分量的个数（通常就最后调用一次）
     */
    public int size() {
        return size;
    }

}
