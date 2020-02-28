package lcci;

import common.TreeNode;

public class Lcci0406 {

    private int target;
    private TreeNode ans;

    private TreeNode getMinNode(TreeNode root) {
        TreeNode ans = root;
        while (root != null) {
            ans = root;
            root = root.left;
        }

        return ans;
    }

    private void dfs(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }

        if (root.val == target) {
            TreeNode rightMinNode = getMinNode(root.right);
            if (rightMinNode != null) {
                ans = rightMinNode;
                return;
            }

            ans = parent;
            return;
        }

        dfs(root.left, root);
        dfs(root.right, parent);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        this.target = p.val;
        dfs(root, null);
        return ans;
    }
    
    public static void main(String[] args) {
        new Lcci0406().inorderSuccessor(new TreeNode(1), new TreeNode(1));
    }

}
