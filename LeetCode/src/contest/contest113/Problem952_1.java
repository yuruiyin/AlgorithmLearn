package contest.contest113;

import java.util.*;

public class Problem952_1 {

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

    private static List<Integer> primeList = new ArrayList<>();
    static {
        int n = 50000;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int max = (int) Math.sqrt(n);
        for (int i = 2; i <= max; i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }

    }

    // 获取所有素因子,素数，质数
    private List<Integer> getPrimeFactors(int num) {
        List<Integer> list = new ArrayList<>();
        for (Integer prime : primeList) {
            if (prime * prime > num) {
                break;
            }

            if (num % prime == 0) {
                list.add(prime);
            }

            while (num % prime == 0) {
                num /= prime;
            }
        }

        if (num > 1 || list.isEmpty()) { // 说明num本身就是素数
            list.add(num);
        }

        return list;
    }

    public int largestComponentSize(int[] arr) {
        List<Integer>[] factorListArr = new ArrayList[100001];

        for (int num : arr) {
            factorListArr[num] = getPrimeFactors(num);
        }

        // 索引代表素因子，值存放的是某个有当前素因子的数的集合。
        SimpleLinkedList[] treeArr = new SimpleLinkedList[100001]; // 并查集
        for (int num : arr) {
            List<Integer> factorList = factorListArr[num];
            Set<SimpleLinkedList> existedTrees = new HashSet<>();
            for (Integer factor: factorList) {
                SimpleLinkedList tree = treeArr[factor];
                if (tree != null) {
                    // 找到已经存在的集合，可能存在多个，比如素因子2，3分别是前面2，3的素因子，而当前数是6，那么就是合并以2和3为索引的集合。
                    existedTrees.add(tree);
                }
            }

            if (existedTrees.isEmpty()) {
                SimpleLinkedList tree = new SimpleLinkedList();
                tree.add(num);
                for (Integer factor: factorList) {
                    treeArr[factor] = tree;
                }
            } else {
                List<SimpleLinkedList> treeList = new ArrayList<>(existedTrees);
                SimpleLinkedList tree1 = treeList.get(0);
                tree1.add(num);
                for (Integer factor: factorList) {
                    treeArr[factor] = tree1;
                }

                if (treeList.size() > 1) {
                    // 合并多棵树
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
