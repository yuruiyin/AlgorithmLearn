package problem201_300;

import common.TreeNode;

public class Problem285 {

    private int pVal;

    private TreeNode getMinNode(TreeNode root) {
        TreeNode ans = root;
        while (ans.left != null) {
            ans = ans.left;
        }
        return ans;
    }

    private TreeNode dfs(TreeNode root, TreeNode parent) {
        if (root == null) {
            return null;
        }

        int curVal = root.val;
        if (curVal == pVal) {
            if (root.right == null) {
                return parent;
            }

            return getMinNode(root.right);
        } else if (curVal < pVal) {
            return dfs(root.right, parent);
        } else {
            return dfs(root.left, root);
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        this.pVal = p.val;
        return dfs(root, null);
    }

}
