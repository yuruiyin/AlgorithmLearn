package problem401_500;

import common.TreeNode;

public class Problem404 {

    private int dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }

        int leftSum = dfs(root.left, true);
        int rightSum = dfs(root.right, false);
        return leftSum + rightSum;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

}
