package problem801_900;

import common.TreeNode;

/**
 * Problem814
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class Problem814 {

    private boolean hasOne(TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean leftHasOne = hasOne(root.left);
        boolean rightHasOne = hasOne(root.right);

        if (!leftHasOne) {
            root.left = null;
        }

        if (!rightHasOne) {
            root.right = null;
        }

        return root.val == 1 || leftHasOne || rightHasOne;
    }

    public TreeNode pruneTree(TreeNode root) {
        boolean rootHasOne = hasOne(root);
        return rootHasOne ? root : null;
    }

}
