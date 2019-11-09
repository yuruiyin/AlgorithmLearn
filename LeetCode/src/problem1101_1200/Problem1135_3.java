package problem1101_1200;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 数组遍历还是比List快
 * kruskal算法中森林中的每棵树使用链表来存储，这样合并树效率高点
 */
public class Problem1135_3 {

    /**
     * 添加元素高效的LinkedList
     */
    static class EfficientLinkedList {

        private int size;

        Node first;
        Node last;

        public void add(WrappedTree e) {
            Node newNode = new Node(e);
            if (last == null) {
                first = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = last.next;
            }
            size++;
        }

        public int size() {
            return size;
        }

        static class Node {
            public WrappedTree item;
            Node next;
            Node(WrappedTree item) {
                this.item = item;
            }
        }
    }

    /**
     * 合并前的树中每个节点所指向的对象
     * 注意：合并后的同一棵树可能存在多个这个对象，不过多个这个对象中的treeId是保持一致的，也就是说通过treeId来表示节点是否处在同一颗树中
     */
    static class WrappedTree {
        private int treeId;
        public WrappedTree(int treeId) {
            this.treeId = treeId;
        }
    }

    private int kruskal(int[][] connections, int nodeCount) {
        // 用于存放每个节点所在的树，当存在树进行合并的时候，需要更新这个值
        WrappedTree[] wrappedTreeOfNodeArr = new WrappedTree[nodeCount + 1];
        EfficientLinkedList[] wrappedTreeListOfTreeIdArr = new EfficientLinkedList[nodeCount+1];

        int ans = 0;
        int curEdgeCount = 0;  //当前生成树中的边数
        int edgeSize = connections.length;
        int needEdgeCount = nodeCount - 1; //最小生成树需要的边数
        int increasedTreeId = 0;
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

            if (wrappedTreeOfNodeArr[node1] != null && wrappedTreeOfNodeArr[node2] != null) {
                // 都在树中，可能是同一颗树，可能是不同树
                WrappedTree wrappedTree1 = wrappedTreeOfNodeArr[node1];
                WrappedTree wrappedTree2 = wrappedTreeOfNodeArr[node2];
                if (wrappedTree1.treeId == wrappedTree2.treeId) { //在同一棵树中
                    continue;
                }

                // 合并树
                EfficientLinkedList wrappedTree1List = wrappedTreeListOfTreeIdArr[wrappedTree1.treeId];
                EfficientLinkedList wrappedTree2List = wrappedTreeListOfTreeIdArr[wrappedTree2.treeId];

                // 少的往多的合并，但是不是修改树中每个node节点的wrappedTree，只是修改WrappedTree对象中的treeId，这样更高效。
                // 高效的原因是，同一颗树中的多个节点可能共享一个WrappedTree对象，因此修改一次WrappedTree对象，就会达到成功修改多个节点的新的隶属tree的效果
                if (wrappedTree1List.size() < wrappedTree2List.size()) {
                    EfficientLinkedList.Node cursor = wrappedTree1List.first;
                    while (cursor != null) {
                        cursor.item.treeId = wrappedTree2.treeId;
                        wrappedTree2List.add(cursor.item);
                        cursor = cursor.next;
                    }
                } else {
                    EfficientLinkedList.Node cursor = wrappedTree2List.first;
                    while (cursor != null) {
                        cursor.item.treeId = wrappedTree1.treeId;
                        wrappedTree1List.add(cursor.item);
                        cursor = cursor.next;
                    }
                }

            } else if (wrappedTreeOfNodeArr[node1] != null && wrappedTreeOfNodeArr[node2] == null) {
                // node1已在树中，node2不在树中, node2直接加入到node1所在的树即可
                wrappedTreeOfNodeArr[node2] = wrappedTreeOfNodeArr[node1];
            } else if (wrappedTreeOfNodeArr[node2] != null && wrappedTreeOfNodeArr[node1] == null) {
                // node2已在树中，node1不在树中, node1直接加入到node2所在的树即可
                wrappedTreeOfNodeArr[node1] = wrappedTreeOfNodeArr[node2];
            } else {
                // 两者都不在已有树中
                WrappedTree wrappedTree = new WrappedTree(increasedTreeId++);
                wrappedTreeOfNodeArr[node1] = wrappedTree;
                wrappedTreeOfNodeArr[node2] = wrappedTree;
                wrappedTreeListOfTreeIdArr[wrappedTree.treeId] = new EfficientLinkedList();
                wrappedTreeListOfTreeIdArr[wrappedTree.treeId].add(wrappedTree);
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
        System.out.println(new Problem1135_3().minimumCost(3, new int[][]{
                {1,2,5},{1,3,6},{2,3,1}
        })); // 6

        System.out.println(new Problem1135_3().minimumCost(4, new int[][]{
                {1,2,3},{3,4,4}
        })); // -1

        System.out.println(new Problem1135_3().minimumCost(6, new int[][]{
                {1,2,1},{1,3,3},{2,4,4},{3,4,2},{4,5,5},{5,6,4}
        })); // 15
    }

}
