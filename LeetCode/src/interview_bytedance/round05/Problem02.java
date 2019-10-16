package interview_bytedance.round05;

import common.TreeNode;

public class Problem02 {

    private int ansMax = 0;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = 0;
        int rightMax = 0;
        if (root.left != null) {
            leftMax = dfs(root.left) + 1;
        }

        if (root.right != null) {
            rightMax = dfs(root.right) + 1;
        }

        int len = leftMax + rightMax;
        if (len > ansMax) {
            ansMax = len;
        }

        return Math.max(leftMax, rightMax);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ansMax;
    }
    
    public static void main(String[] args) {

    }
    
}
