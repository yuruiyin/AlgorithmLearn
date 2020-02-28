package lcci;

import common.TreeNode;

public class Lcci0412 {

    private int rec(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int leftCount = rec(root.left, sum - root.val);
        int rightCount = rec(root.right, sum - root.val);
        int curCount = root.val == sum ? 1 : 0;
        return curCount + leftCount + rightCount;
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int count = rec(root, sum);
        int leftCount = pathSum(root.left, sum);
        int rightCount = pathSum(root.right, sum);
        return count + leftCount + rightCount;
    }

}
