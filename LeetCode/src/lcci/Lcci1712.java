package lcci;

import common.TreeNode;

/**
 * Lcci1712
 *
 * @author: yry
 * @date: 2020/4/13
 */
public class Lcci1712 {

    // 每棵子树返回最小和最大的节点
    private TreeNode[] dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new TreeNode[]{root, root};
        }

        TreeNode[] leftRes = null;
        if (root.left != null) {
            leftRes = dfs(root.left);
        }

        TreeNode[] rightRes = null;
        if (root.right != null) {
            rightRes = dfs(root.right);
        }

        TreeNode[] res = new TreeNode[]{root, root};
        if (leftRes != null) {
            TreeNode leftMin = leftRes[0];
            TreeNode leftMax = leftRes[1];
            leftMax.right = root;
            res[0] = leftMin;
        }

        if (rightRes != null) {
            TreeNode rightMin = rightRes[0];
            TreeNode rightMax = rightRes[1];
            root.right = rightMin;
            res[1] = rightMax;
        }

        root.left = null;
        return res;
    }

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode[] ans = dfs(root);
        return ans[0];
    }

}
