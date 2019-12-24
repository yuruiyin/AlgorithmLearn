package problem601_700;

import common.TreeNode;

public class Problem700_1 {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;

        while (cur != null) {
            if (val == cur.val) {
                return cur;
            } else if (val < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return null;
    }

}
