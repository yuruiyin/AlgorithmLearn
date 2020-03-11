package problem501_600;

import common.TreeNode;

public class Problem543_1 {

    private int ansMax = 0;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        int sum = leftMax + rightMax + 1;
        ansMax = Math.max(ansMax, sum);
        return Math.max(leftMax, rightMax) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return ansMax - 1;
    }

}
