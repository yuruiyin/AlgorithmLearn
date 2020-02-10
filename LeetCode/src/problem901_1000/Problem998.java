package problem901_1000;

import common.TreeNode;

public class Problem998 {

    private TreeNode ans;

    private boolean dfs(TreeNode root, int val, TreeNode parent) {
        if (root == null) {
            return false;
        }

        boolean isFound = dfs(root.right, val, root);
        if (isFound) {
            return true;
        }

        if (val > root.val) {
            if (parent != null) {
                return false;
            }

            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            ans = newRoot;
            return true;
        } else {
            TreeNode oldRight = root.right;
            root.right = new TreeNode(val);
            if (oldRight != null) {
                root.right.left = oldRight;
            }

            return true;
        }
    }

    private TreeNode copy(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode node = new TreeNode(root.val);
        node.left = copy(root.left);
        node.right = copy(root.right);
        return node;
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        ans = copy(root);
        dfs(ans, val, null);
        return ans;
    }

}
