package problem1101_1200;

import java.util.*;

/**
 * 数组遍历还是比List快
 * kruskal算法中森林中的每棵树使用链表来存储，这样合并树效率高点
 */
public class Problem1135_2 {

    /**
     * 自定义链表list，用于存储Kruskal算法中森林中的树，一个list对应一棵树，主要是为了提升合并的效率。
     */
    static class SimpleLinkedList {
        private int size;

        private Node first;
        private Node last;

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
            Node next;
            Node(int val) {
                this.val = val;
            }
        }

    }

    private int kruskal(int[][] connections, int nodeCount) {
        // 用于存放每个节点所在的树，当存在树进行合并的时候，需要更新这个值
        SimpleLinkedList[] nodeTreeSetMap = new SimpleLinkedList[nodeCount + 1];

        int ans = 0;
        int curEdgeCount = 0;  //当前生成树中的边数
        int edgeSize = connections.length;
        int needEdgeCount = nodeCount - 1; //最小生成树需要的边数
        for (int i = 0; i < edgeSize; i++) {
            int[] connection = connections[i];
            int node1 = connection[0];
            int node2 = connection[1];

            if (edgeSize - i + curEdgeCount < needEdgeCount) {
                // 后面剩余的边数已经不够了，直接返回就可以了
                return -1;
            }

            if (curEdgeCount == needEdgeCount) {
                break;
            }

            if (nodeTreeSetMap[node1] != null && nodeTreeSetMap[node2] != null) {
                // 都在树中，可能是同一颗树，可能是不同树
                SimpleLinkedList set1 = nodeTreeSetMap[node1];
                SimpleLinkedList set2 = nodeTreeSetMap[node2];
                if (set1 == set2) { //在同一棵树中
                    continue;
                }

                // 合并树，节点少的往节点多的合并
                if (set1.size() < set2.size()) {
                    set2.addLinkedList(set1);  // 一个链表的尾指向另一个链表的头即可
                    // 保留set2，要删除set1，因此更新set1中所有节点的nodeTreeSetMap
                    SimpleLinkedList.Node cursor = set1.first;
                    while (cursor != null) {
                        nodeTreeSetMap[cursor.val] = set2;
                        cursor = cursor.next;
                    }
                } else {
                    set1.addLinkedList(set2);
                    // 保留set1，要删除set2，因此更新set2中所有节点的nodeTreeSetMap
                    SimpleLinkedList.Node cursor = set2.first;
                    while (cursor != null) {
                        nodeTreeSetMap[cursor.val] = set1;
                        cursor = cursor.next;
                    }
                }
            } else if (nodeTreeSetMap[node1] != null && nodeTreeSetMap[node2] == null) {
                // node1已在树中，node2不在树中, node2直接加入到node1所在的树即可
                SimpleLinkedList set1 = nodeTreeSetMap[node1];
                set1.add(node2);
                nodeTreeSetMap[node2] = set1;
            } else if (nodeTreeSetMap[node2] != null && nodeTreeSetMap[node1] == null) {
                // node2已在树中，node1不在树中, node1直接加入到node2所在的树即可
                SimpleLinkedList set2 = nodeTreeSetMap[node2];
                set2.add(node1);
                nodeTreeSetMap[node1] = set2;
            } else {
                // 两者都不在已有树中
                SimpleLinkedList set = new SimpleLinkedList();
                set.add(node1);
                set.add(node2);
                nodeTreeSetMap[node1] = set;
                nodeTreeSetMap[node2] = set;
            }

            ans += connection[2];
            curEdgeCount++;
        }

        if (curEdgeCount != needEdgeCount) {
            return -1;
        }

        return ans;
    }

    public int minimumCost(int n, int[][] connections) {
        // 最小生成树算法，kruskal，从最小权值的边开始将边加入到树里头，同时每次要加入的两个节点不能在一颗树里（否则会形成环，也就是变成多余的边）
        // 直到最后所有的顶点都在一颗树内或者有n-1条边为止

        if (connections.length < n - 1) {
            return -1;
        }

        // 这样最快
        Arrays.sort(connections, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];  // 按照cost从小到大排序
            }
        });

        return kruskal(connections, n);
    }
    public static void main(String[] args) {
        System.out.println(new Problem1135_2().minimumCost(3, new int[][]{
                {1,2,5},{1,3,6},{2,3,1}
        })); // 6

        System.out.println(new Problem1135_2().minimumCost(4, new int[][]{
                {1,2,3},{3,4,4}
        })); // -1

        System.out.println(new Problem1135_2().minimumCost(6, new int[][]{
                {1,2,1},{1,3,3},{2,4,4},{3,4,2},{4,5,5},{5,6,4}
        })); // 15
    }

}
