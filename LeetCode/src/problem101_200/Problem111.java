package problem101_200;

import common.TreeNode;

public class Problem111 {

    private int dfs(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftMinHeight = dfs(root.left);
        int rightMinHeight = dfs(root.right);

        return Math.min(leftMinHeight, rightMinHeight) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root);
    }
    
    public static void main(String[] args) {

    }
    
}
