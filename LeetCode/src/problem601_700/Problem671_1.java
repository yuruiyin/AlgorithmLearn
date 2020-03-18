package problem601_700;

import common.TreeNode;

/**
 * Problem671_1
 *
 * @author: yry
 * @date: 2020/3/16
 */
public class Problem671_1 {

    private int rootVal;

    private long dfs(TreeNode root) {
        if (root == null) {
            return Long.MAX_VALUE;
        }

        if (root.val != rootVal) {
            return root.val;
        }

        long leftMin = dfs(root.left);
        long rightMin = dfs(root.right);
        return Math.min(leftMin, rightMin);
    }

    public int findSecondMinimumValue(TreeNode root) {
        rootVal = root.val;
        long ans = dfs(root);
        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }

}
