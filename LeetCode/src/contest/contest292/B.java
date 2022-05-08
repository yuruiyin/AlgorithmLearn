package contest.contest292;

import common.TreeNode;

public class B {

    private int ans = 0;

    private int[] dfs(TreeNode cur) {
        if (cur == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(cur.left);
        int[] right = dfs(cur.right);
        int count = left[0] + right[0] + 1;
        int sum = left[1] + right[1] + cur.val;
        int aver = sum / count;
        if (aver == cur.val) {
            ans++;
        }
        return new int[]{count, sum};
    }

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

}
