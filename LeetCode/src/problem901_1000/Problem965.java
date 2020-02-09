package problem901_1000;

import common.TreeNode;

public class Problem965 {

    private int val;

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.val != val) {
            return false;
        }

        return dfs(root.left) && dfs(root.right);
    }

    public boolean isUnivalTree(TreeNode root) {
        val = root.val;
        return dfs(root);
    }

}
