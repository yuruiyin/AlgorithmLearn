package problem201_300;

import common.TreeNode;

public class Problem226 {

    private void dfs(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            // 叶子
            return;
        }

        // 递归替换左右子节点即可
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        dfs(root.left);
        dfs(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        dfs(root);
        return root;
    }

}
