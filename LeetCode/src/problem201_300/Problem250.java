package problem201_300;

import common.TreeNode;

public class Problem250 {

    private int ansCount = 0;

    private boolean isSame(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isLeftOk = false;
        if (root.left == null || isSame(root.left) && root.val == root.left.val) {
            isLeftOk = true;
        }

        boolean isRightOk = false;
        if (root.right == null || isSame(root.right) && root.val == root.right.val) {
            isRightOk = true;
        }

        if (isLeftOk && isRightOk) {
            ansCount++;
            return true;
        }

        return false;
    }

    public int countUnivalSubtrees(TreeNode root) {
        isSame(root);
        return ansCount;
    }

}
