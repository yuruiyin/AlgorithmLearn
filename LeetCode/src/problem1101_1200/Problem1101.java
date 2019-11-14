package problem1101_1200;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1101 {

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


    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        SimpleLinkedList[] treeList = new SimpleLinkedList[n];

        for (int[] log: logs) {
            int first = log[1];
            int second = log[2];
            SimpleLinkedList tree1 = treeList[first];
            SimpleLinkedList tree2 = treeList[second];
            if (tree1 != null && tree2 != null) {
                if (tree1 == tree2) {
                    continue;
                }

                // 合并
                if (tree1.size() > tree2.size()) {
                    tree1.addLinkedList(tree2);
                    SimpleLinkedList.Node cursor = tree2.first;
                    while (cursor != null) {
                        treeList[cursor.val] = tree1;
                        cursor = cursor.next;
                    }
                } else {
                    tree2.addLinkedList(tree1);
                    SimpleLinkedList.Node cursor = tree1.first;
                    while (cursor != null) {
                        treeList[cursor.val] = tree2;
                        cursor = cursor.next;
                    }
                }
            } else if (tree1 != null) {
                tree1.add(second);
                treeList[second] = tree1;
            } else if (tree2 != null) {
                tree2.add(first);
                treeList[first] = tree2;
            } else {
                SimpleLinkedList list = new SimpleLinkedList();
                list.add(first);
                list.add(second);
                treeList[first] = list;
                treeList[second] = list;
            }

            if (treeList[0] != null && treeList[0].size() == n) {
                return log[0];
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        
    }
    
}
