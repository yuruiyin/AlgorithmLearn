package lcp;

import utils.PrintUtil;

import java.util.*;

public class Problem05 {

    private static final int MOD = 1000000007;
    private Node[] nodeArr;
    private List<Integer>[] childList;
    private int[] parent;

    class Node {
        int id;
        int treeNodeCount; // 以当前节点为根的子树的节点数
        long totalTreeNodeCoin; // 以当前节点为根的子树的coin数（但不包含祖先节点所发放的coin数）
        Node(int id) {
            this.id = id;
        }
    }

    /**
     * 计算以每个节点为根的子树的节点数，并保存到node节点上
     */
    private int calcTreeNodeCount(int nodeId) {
        if (childList[nodeId] == null) {
            // 叶子
            nodeArr[nodeId].treeNodeCount = 1;
            return 1;
        }

        int treeNodeCount = 1;
        for (Integer childId: childList[nodeId]) {
            treeNodeCount += calcTreeNodeCount(childId);
        }

        nodeArr[nodeId].treeNodeCount = treeNodeCount;
        return treeNodeCount;
    }

    /**
     * 当执行操作1和操作2的时候，更新所有祖先节点的totalTreeNodeCoin
     */
    private void updateAncestorTotalNodeCoin(int nodeId, int coin) {
        while (nodeId != 0) {
            nodeArr[nodeId].totalTreeNodeCoin += coin;
            nodeId = parent[nodeId];
        }
    }

    /**
     * 当执行操作2的时候，需要先更新每个孩子节点的totalTreeNodeCoin
     */
    private void updateChildTotalNodeCoin(int nodeId, int coin) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(nodeId);

        while (!queue.isEmpty()) {
            int front = queue.removeFirst();
            Node node = nodeArr[front];
            node.totalTreeNodeCoin += node.treeNodeCount * coin;
            if (childList[front] != null) {
                queue.addAll(childList[front]);
            }
        }

    }

    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        parent = new int[n+1];
        childList = new ArrayList[n+1];
        nodeArr = new Node[n+1];

        for (int i = 0; i < n + 1; i++) {
            nodeArr[i] = new Node(i);
        }

        for (int[] ship : leadership) {
            parent[ship[1]] = ship[0];
            if (childList[ship[0]] == null) {
                childList[ship[0]] = new ArrayList<>();
            }

            childList[ship[0]].add(ship[1]);
        }

        calcTreeNodeCount(1);
        List<Integer> ansList = new ArrayList<>();

        // 假设各个操作被操作3（查询）分割成多个区间，以下将当前查询前面最近的区间进行打包处理
        int[] prevArr1 = new int[n+1];
        int[] prevArr2 = new int[n+1];
        List<Integer> prevIndexList1 = new ArrayList<>();
        List<Integer> prevIndexList2 = new ArrayList<>();

        for (int[] operation: operations) {
            int oper = operation[0];
            int nodeId = operation[1];
            Node node = nodeArr[nodeId];
            if (oper == 1) {
                int coin = operation[2];
                prevArr1[nodeId] += coin;
                prevIndexList1.add(nodeId);
            } else if (oper == 2) {
                int coin = operation[2];
                prevArr2[nodeId] += coin;
                prevIndexList2.add(nodeId);
            } else {
                // 查询
                for (Integer nodeId1: prevIndexList1) {
                    updateAncestorTotalNodeCoin(nodeId1, prevArr1[nodeId1]);
                    prevArr1[nodeId1] = 0;
                }

                for (Integer nodeId2 : prevIndexList2) {
                    int coin = prevArr2[nodeId2];
                    updateChildTotalNodeCoin(nodeId2, coin);   // 先更新所有孩子节点
                    updateAncestorTotalNodeCoin(parent[nodeId2], coin * nodeArr[nodeId2].treeNodeCount); // 再更新祖先节点
                    prevArr2[nodeId2] = 0;
                }

                prevIndexList1.clear();
                prevIndexList2.clear();

                ansList.add((int) (node.totalTreeNodeCoin % MOD));
            }
        }

        int querySize = ansList.size();
        int[] ansArr = new int[querySize];

        for (int i = 0; i < querySize; i++) {
            ansArr[i] = ansList.get(i);
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[] ans = new Problem05().bonus(6, new int[][]{
                {1, 2}, {1, 6}, {2, 3}, {2, 5}, {1, 4}
        }, new int[][]{
                {1, 1, 500}, {2, 2, 50}, {3, 1}, {2, 6, 15}, {3, 1}
        });

        PrintUtil.printIntArray(ans);
    }

}
