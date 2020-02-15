package lcof;

import common.TreeNode;

public class Lcof055_1_1 {

    private int ansMax = 0;

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            ansMax = Math.max(ansMax, level);
            return;
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return ansMax;
    }

}
