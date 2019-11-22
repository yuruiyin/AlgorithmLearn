package problem101_200;

import common.TreeNode;

public class Problem110 {

    class Result {
        boolean isBalance;
        int height;
        Result(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(true, 0);
        }

        Result leftRes = dfs(root.left);
        Result rightRes = dfs(root.right);

        boolean isBalance = leftRes.isBalance && rightRes.isBalance && Math.abs(leftRes.height - rightRes.height) <= 1 ;
        int height = Math.max(leftRes.height, rightRes.height) + 1;

        return new Result(isBalance, height);
    }

    public boolean isBalanced(TreeNode root) {
        Result result = dfs(root);
        return result.isBalance;
    }
    
    public static void main(String[] args) {

    }
    
}
