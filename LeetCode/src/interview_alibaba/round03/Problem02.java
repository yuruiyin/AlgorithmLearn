package interview_alibaba.round03;

import common.TreeNode;

public class Problem02 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            // 叶子
            return;
        }

        if (root.left != null) {
            flatten(root.left);
        }

        if (root.right != null) {
            flatten(root.right);
        }

        if (root.left == null) {
            return;
        }

        TreeNode oldRight = root.right;
        TreeNode oldLeft = root.left;
        root.right = oldLeft;
        TreeNode cur = oldLeft;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = oldRight;
        root.left = null;
    }
   
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        new Problem02().flatten(root);
    }
    
}
