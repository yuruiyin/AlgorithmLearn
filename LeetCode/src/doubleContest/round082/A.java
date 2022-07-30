package doubleContest.round082;

import common.TreeNode;

public class A {

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if (root.val == 2) {
            return left || right;
        }
        return left && right;
    }

    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
