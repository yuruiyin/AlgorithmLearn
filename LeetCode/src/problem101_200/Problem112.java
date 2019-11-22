package problem101_200;

import common.TreeNode;

public class Problem112 {

    private boolean dfs(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return dfs(root, sum);
    }
    
    public static void main(String[] args) {

    }
    
}
