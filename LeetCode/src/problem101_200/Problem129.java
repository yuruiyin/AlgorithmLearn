package problem101_200;

import common.TreeNode;

public class Problem129 {

    private int ans;

    private void dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return;
        }

        prevSum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            ans += prevSum;
            return;
        }

        dfs(root.left, prevSum);
        dfs(root.right, prevSum);
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

}
