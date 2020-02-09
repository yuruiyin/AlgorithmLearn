package problem901_1000;

import common.TreeNode;

public class Problem979 {

    private int ans;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        ans += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }

    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.left.left.left = new TreeNode(1);
        System.out.println(new Problem979().distributeCoins(root));
    }

}
