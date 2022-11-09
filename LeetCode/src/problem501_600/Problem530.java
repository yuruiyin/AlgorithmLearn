package problem501_600;

import common.TreeNode;

public class Problem530 {

    private int ansMinDiff = Integer.MAX_VALUE;

    private int[] dfs(TreeNode cur) {
        if (cur.left == null && cur.right == null) {
            // leaf
            return new int[]{cur.val, cur.val};
        }

        int[] leftRes = cur.left != null ? dfs(cur.left) : null;
        int[] rightRes = cur.right != null ? dfs(cur.right) : null;
        int[] res = new int[]{cur.val, cur.val};
        if (leftRes != null) {
            ansMinDiff = Math.min(ansMinDiff, cur.val - leftRes[1]);
            res[0] = leftRes[0];
        }
        if (rightRes != null) {
            ansMinDiff = Math.min(ansMinDiff, rightRes[0] - cur.val);
            res[1] = rightRes[1];
        }

        return res;
    }

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ansMinDiff;
    }

}
