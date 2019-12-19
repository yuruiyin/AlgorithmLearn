package problem201_300;

public class Problem261_1 {

    /**
     * 自定义链表list，用于存储Kruskal算法中森林中的树，一个list对应一棵树，主要是为了提升合并的效率。
     */
    static class SimpleLinkedList {
        private int size;

        private SimpleLinkedList.Node first;
        private SimpleLinkedList.Node last;

        public void add(int value) {
            SimpleLinkedList.Node newNode = new SimpleLinkedList.Node(value);
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
        public void addLinkedList(SimpleLinkedList linkedList) {
            if (last == null) {
                first = linkedList.first;
                last = linkedList.last;
            } else {
                last.next = linkedList.first;
                last = linkedList.last;
            }

            size += linkedList.size;
        }

        public int size() {
            return size;
        }

        static class Node {
            int val;
            SimpleLinkedList.Node next;
            Node(int val) {
                this.val = val;
            }
        }

    }

    // 并查集，遍历没条边，判断边的两个顶点是否已经存在于同一颗树中，若是，则加入这条边会生成环。
    // 若后面无环，则判断最终并到一棵树的节点数是否等于n，如果是，则说明所有节点都并到了一棵树上，也就是说就一个联通分支，也就是说明这张图就是一棵树
    public boolean validTree(int n, int[][] edges) {
        SimpleLinkedList[] nodeToTree = new SimpleLinkedList[n];

        if (edges.length == 0) {
            return n == 1;
        }

        for (int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            SimpleLinkedList tree1 = nodeToTree[node1];
            SimpleLinkedList tree2 = nodeToTree[node2];

            if (tree1 != null && tree2 != null) {
                if (tree1 == tree2) {
                    return false; //存在环
                }

                // 小树往大树合并，开销小
                if (tree1.size() < tree2.size()) {
                    // tree1合并到tree2中
                    tree2.addLinkedList(tree1);
                    SimpleLinkedList.Node cur = tree1.first;
                    while (cur != null) {
                        nodeToTree[cur.val] = tree2;
                        cur = cur.next;
                    }
                } else {
                    // tree2合并到tree1中
                    tree1.addLinkedList(tree2);
                    SimpleLinkedList.Node cur = tree2.first;
                    while (cur != null) {
                        nodeToTree[cur.val] = tree1;
                        cur = cur.next;
                    }
                }
            } else if (tree1 != null) {
                // tree2 == null
                tree1.add(node2);
                nodeToTree[node2] = tree1;
            } else if (tree2 != null) {
                tree2.add(node1);
                nodeToTree[node1] = tree2;
            } else {
                SimpleLinkedList tree = new SimpleLinkedList();
                tree.add(node1);
                tree.add(node2);
                nodeToTree[node1] = tree;
                nodeToTree[node2] = tree;
            }
        }

        return nodeToTree[0] != null && nodeToTree[0].size() == n;
    }

}
