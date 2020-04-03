package problem501_600;

import common.TreeNode;

/**
 * Problem572_1
 *
 * @author: yry
 * @date: 2020/4/3
 */
public class Problem572_1 {

    private boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        }

        if (root2 == null) {
            return false;
        }

        return root1.val == root2.val && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }

    private boolean isFoundSame = false;
    private int tCount;

    private int calcCount(TreeNode root, TreeNode t) {
        if (isFoundSame) {
            return 0;
        }

        if (root == null) {
            return 0;
        }

        int count = calcCount(root.left, t) + calcCount(root.right, t) + 1;
        if (count == tCount && isSame(root, t)) {
            isFoundSame = true;
            return 0;
        }
        return count;
    }

    private int calcTCount(TreeNode root) {
        return root == null ? 0 : calcTCount(root.left) + calcTCount(root.right) + 1;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        tCount = calcTCount(t);
        calcCount(s, t);
        return isFoundSame;
    }

}
