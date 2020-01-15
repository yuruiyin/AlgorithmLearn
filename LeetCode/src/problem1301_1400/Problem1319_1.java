package problem1301_1400;

import java.util.HashSet;
import java.util.Set;

public class Problem1319_1 {

    /**
     * 自定义链表list，用于存储Kruskal算法中森林中的树，一个list对应一棵树，主要是为了提升合并的效率。
     * 并查集链表
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

    public int makeConnected(int n, int[][] connections) {
        int edgeCount = connections.length;
        if (edgeCount < n - 1) {
            return -1;
        }

        SimpleLinkedList[] treeArr = new SimpleLinkedList[n];

        for (int[] con : connections) {
            int node1 = con[0];
            int node2 = con[1];
            SimpleLinkedList tree1 = treeArr[node1];
            SimpleLinkedList tree2 = treeArr[node2];

            if (tree1 != null && tree2 != null) {
                if (tree1 == tree2) {
                    continue;
                }

                if (tree1.size() > tree2.size()) {
                    tree1.addLinkedList(tree2);
                    SimpleLinkedList.Node cursor = tree2.first;
                    while (cursor != null) {
                        treeArr[cursor.val] = tree1;
                        cursor = cursor.next;
                    }
                } else {
                    tree2.addLinkedList(tree1);
                    SimpleLinkedList.Node cursor = tree1.first;
                    while (cursor != null) {
                        treeArr[cursor.val] = tree2;
                        cursor = cursor.next;
                    }
                }

            } else if (tree1 != null) {
                tree1.add(node2);
                treeArr[node2] = tree1;
            } else if (tree2 != null) {
                tree2.add(node1);
                treeArr[node1] = tree2;
            } else {
                SimpleLinkedList tree = new SimpleLinkedList();
                tree.add(node1);
                tree.add(node2);
                treeArr[node1] = tree;
                treeArr[node2] = tree;
            }
        }

        Set<SimpleLinkedList> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (treeArr[i] == null) {
                treeArr[i] = new SimpleLinkedList();
                treeArr[i].add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            set.add(treeArr[i]);
        }

        return set.size() - 1;
    }

}
