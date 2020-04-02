package problem701_800;

import common.TreeNode;

/**
 * Problem776
 *
 * @author: yry
 * @date: 2020/4/2
 */
public class Problem776 {

    public TreeNode[] splitBST(TreeNode root, int v) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (root.val == v) {
            TreeNode max = root.right;
            root.right = null;
            return new TreeNode[]{root, max};
        } else if (root.val < v) {
            TreeNode[] rightRes = splitBST(root.right, v);
            root.right = rightRes[0];
            return new TreeNode[]{root, rightRes[1]};
        } else {
            TreeNode[] leftRes = splitBST(root.left, v);
            root.left = leftRes[1];
            return new TreeNode[]{leftRes[0], root};
        }
    }

}
