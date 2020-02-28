package lcci;

import common.TreeNode;

public class Lcci0404 {

    class Result {
        int height;
        boolean isBalance;
        Result(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(0, true);
        }

        Result leftRes = dfs(root.left);
        Result rightRes = dfs(root.right);

        if (!leftRes.isBalance || !rightRes.isBalance || Math.abs(leftRes.height - rightRes.height) > 1) {
            return new Result(0, false);
        }

        int height = Math.max(leftRes.height, rightRes.height) + 1;
        return new Result(height, true);
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalance;
    }

}
