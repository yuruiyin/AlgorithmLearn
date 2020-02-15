package lcof;

import common.TreeNode;

public class Lcof028 {

    private boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.val == root2.val && dfs(root1.left, root2.right) && dfs(root1.right, root2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }

        return dfs(root.left, root.right);
    }

}
