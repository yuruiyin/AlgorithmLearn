package problem001_100;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem099 {

    private void inOrder(TreeNode root, List<TreeNode> nodeList) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inOrder(root.left, nodeList);
        }

        nodeList.add(root);

        if (root.right != null) {
            inOrder(root.right, nodeList);
        }
    }

    private void swapNode(TreeNode node1, TreeNode node2) {
        Integer tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        inOrder(root, nodeList);

        int size = nodeList.size();

        // 从左往右找到第一个比后面大的元素
        TreeNode firstBiggerNode = nodeList.get(0);
        for (int i = 0; i < size - 1; i++) {
            TreeNode node = nodeList.get(i);
            TreeNode nextNode = nodeList.get(i + 1);
            if (node.val > nextNode.val) {
                firstBiggerNode = node;
                break;
            }
        }

        // 从右往左找到第一个比前面小的元素
        TreeNode lastSmallerNode = nodeList.get(size - 1);
        for (int i = size - 1; i >= 1; i--) {
            TreeNode node = nodeList.get(i);
            TreeNode prevNode = nodeList.get(i - 1);
            if (node.val < prevNode.val) {
                lastSmallerNode = node;
                break;
            }
        }

        swapNode(firstBiggerNode, lastSmallerNode);
    }

    private void printNode(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.addLast(root);

        while (!queue.isEmpty()) {
            TreeNode front = queue.removeFirst();
            System.out.print(front.val + ",");

            if (front.left != null) {
                queue.addLast(front.left);
            }

            if (front.right != null) {
                queue.addLast(front.right);
            }
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        new Problem099().recoverTree(root);
        new Problem099().printNode(root);
    }
    
}
