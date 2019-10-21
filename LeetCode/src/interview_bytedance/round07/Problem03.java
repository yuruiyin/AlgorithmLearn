package interview_bytedance.round07;

import common.TreeNode;

public class Problem03 {

    private TreeNode errorFirstNode;
    private TreeNode errorSecondNode;
    private TreeNode lastNode;

    private boolean hasFound = false;

    private void inOrder(TreeNode root) {
        if (root == null || hasFound) {
            return;
        }

        if (root.left != null) {
            inOrder(root.left);
        }

        if (lastNode != null && lastNode.val > root.val) {
            if (errorFirstNode == null) {
                errorFirstNode = lastNode;
                errorSecondNode = root;
            } else {
                errorSecondNode = root;
                hasFound = true;
            }
        }
        lastNode = root;

        if (root.right != null) {
            inOrder(root.right);
        }
    }

    private void swapNode(TreeNode node1, TreeNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }

    public void recoverTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }

        inOrder(root);

        if (errorFirstNode != null && errorSecondNode != null) {
            swapNode(errorFirstNode, errorSecondNode);
        }
    }
    
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(3);
//        root.left.right = new TreeNode(2);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        new Problem03().recoverTree(root);
        
        System.out.println(root.val);
    }
    
}
