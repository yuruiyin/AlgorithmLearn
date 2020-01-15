package contest.contest113;

import java.util.*;

public class Problem952 {

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

    private boolean isPrime(int num) {
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> getPrimeFactors(int num) {
        List<Integer> list = new ArrayList<>();
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                if (isPrime(i)) {
                    list.add(i);
                }
                if (isPrime(num / i)) {
                    list.add(num / i);
                }
            }
        }

        if (list.isEmpty()) {
            list.add(num);
        }

        return list;
    }

    public int largestComponentSize(int[] arr) {
        List<Integer>[] factorListArr = new ArrayList[100001];

        for (int num : arr) {
            factorListArr[num] = getPrimeFactors(num);
        }

        SimpleLinkedList[] treeArr = new SimpleLinkedList[100001]; // 并查集
        for (int num : arr) {
            List<Integer> factorList = factorListArr[num];
            Set<SimpleLinkedList> existedTrees = new HashSet<>();
            for (Integer factor: factorList) {
                SimpleLinkedList tree = treeArr[factor];
                if (tree != null) {
                    // 找到已经存在的集合
                    existedTrees.add(tree);
                }
            }

            if (existedTrees.isEmpty()) {
                SimpleLinkedList list = new SimpleLinkedList();
                list.add(num);
                for (Integer factor: factorList) {
                    treeArr[factor] = list;
                }
            } else {
                List<SimpleLinkedList> treeList = new ArrayList<>(existedTrees);
                if (treeList.size() == 1) {
                    SimpleLinkedList tree = treeList.get(0);
                    tree.add(num);
                    for (Integer factor: factorList) {
                        treeArr[factor] = tree;
                    }
                } else {
                    // 合并多课树
                    SimpleLinkedList tree1 = treeList.get(0);
                    for (int i = 1; i < treeList.size(); i++) {
                        SimpleLinkedList curTree = treeList.get(i);
                        tree1.addLinkedList(curTree);
                        SimpleLinkedList.Node curNode = curTree.first;
                        while (curNode != null) {
                            for (Integer factor: factorListArr[curNode.val]) {
                                treeArr[factor] = tree1;
                            }
                            curNode = curNode.next;
                        }
                    }

                    tree1.add(num);
                    for (Integer factor: factorList) {
                        treeArr[factor] = tree1;
                    }
                }
            }
        }

        int maxSize = 0;
        for (int i = 2; i < 100001; i++) {
            if (treeArr[i] != null && treeArr[i].size() > maxSize) {
                maxSize = treeArr[i].size();
            }
        }

        return maxSize;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem952().largestComponentSize(new int[]{4,6,15,35}));
    }

}
