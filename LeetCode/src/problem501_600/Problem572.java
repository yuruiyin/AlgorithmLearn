package problem501_600;

import common.TreeNode;

/**
 * Problem572
 *
 * @author: yry
 * @date: 2020/4/3
 */
public class Problem572 {

    private boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        }

        if (root2 == null) {
            return false;
        }

        return root1.val == root2.val && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        if (isSame(s, t)) {
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

}
