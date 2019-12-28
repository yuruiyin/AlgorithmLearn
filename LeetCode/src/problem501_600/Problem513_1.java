package problem501_600;

import common.TreeNode;

public class Problem513_1 {

    private int maxLevel = -1;
    private int ans = -1;

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (level > maxLevel) {
                maxLevel = level;
                ans = root.val;
            }
            return;
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

}
