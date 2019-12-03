package problem201_300;

import common.TreeNode;

public class Problem236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        // p,q要不都在左子树，要不都在右子树, 要么左右子树都没有
        return left != null ? left : right;
    }

}
