package fall_2022_group;

import common.TreeNode;

public class B {

    private void dfs(TreeNode cur) {
        if (cur == null || (cur.left == null && cur.right == null)) {
            return;
        }

        if (cur.left != null) {
            TreeNode node = new TreeNode(-1);
            TreeNode oldLeft = cur.left;
            cur.left = node;
            node.left = oldLeft;
            dfs(oldLeft);
        }

        if (cur.right != null) {
            TreeNode node = new TreeNode(-1);
            TreeNode oldRight = cur.right;
            cur.right = node;
            node.right = oldRight;
            dfs(oldRight);
        }
    }

    public TreeNode expandBinaryTree(TreeNode root) {
        dfs(root);
        return root;
    }

}
