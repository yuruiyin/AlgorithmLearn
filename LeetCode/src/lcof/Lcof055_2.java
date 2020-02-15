package lcof;

import common.TreeNode;

public class Lcof055_2 {

    class Result {
        boolean isBalance;
        int depth;
        Result(boolean isBalance, int depth) {
            this.isBalance = isBalance;
            this.depth = depth;
        }
    }

    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(true, 0);
        }

        Result leftRes = dfs(root.left);
        Result rightRes = dfs(root.right);

        boolean isBalance = leftRes.isBalance && rightRes.isBalance && Math.abs(leftRes.depth - rightRes.depth) <= 1;
        return new Result(isBalance, Math.max(leftRes.depth, rightRes.depth) + 1);
    }

    public boolean isBalanced(TreeNode root) {
        Result result = dfs(root);
        return result.isBalance;
    }

}
