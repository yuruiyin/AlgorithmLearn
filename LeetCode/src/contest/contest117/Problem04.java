package contest.contest117;

import common.TreeNode;

public class Problem04 {

    class Result {
        int isRootInstallMinCount;
        int isRootNotInstallMinCount;
        Result(int isRootInstallMinCount, int isRootNotInstallMinCount) {
            this.isRootInstallMinCount = isRootInstallMinCount;
            this.isRootNotInstallMinCount = isRootNotInstallMinCount;
        }
    }

    private Result[] memo;

    private Result dp(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Result(1, 0);
        }

        if (memo[root.val] != null) {
            return memo[root.val];
        }

        Result leftRes = null;
        if (root.left != null) {
            leftRes = dp(root.left);
        }

        Result rightRes = null;
        if (root.right != null) {
            rightRes = dp(root.right);
        }

        int hasChildInstallMinCount;
        int noChildInstallMinCount;
        if (leftRes == null) {
            hasChildInstallMinCount = rightRes.isRootInstallMinCount;
            noChildInstallMinCount = rightRes.isRootNotInstallMinCount;
        } else if (rightRes == null) {
            hasChildInstallMinCount = leftRes.isRootInstallMinCount;
            noChildInstallMinCount = leftRes.isRootNotInstallMinCount;
        } else {
            int leftAndRightAllInstallCount = leftRes.isRootInstallMinCount + rightRes.isRootInstallMinCount;
            int leftInstallCount = leftRes.isRootInstallMinCount + rightRes.isRootNotInstallMinCount;
            int rightInstallCount = leftRes.isRootNotInstallMinCount + rightRes.isRootInstallMinCount;
            int leftAndRightAllNotInstallCount = leftRes.isRootNotInstallMinCount + rightRes.isRootNotInstallMinCount;

            hasChildInstallMinCount = Math.min(Math.min(leftInstallCount, rightInstallCount), leftAndRightAllInstallCount);
            noChildInstallMinCount = leftAndRightAllNotInstallCount;
        }

        memo[root.val] = new Result(noChildInstallMinCount + 1, hasChildInstallMinCount);
        return memo[root.val];
    }

    private int index = 0;

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        root.val = index++;
        dfs(root.left);
        dfs(root.right);
    }

    public int minCameraCover(TreeNode root) {
        dfs(root);
        memo = new Result[1001];

        if (root.left == null && root.right == null) {
            return 1;
        }

        Result res = dp(root);
        return Math.min(res.isRootInstallMinCount, res.isRootNotInstallMinCount);
    }

}
