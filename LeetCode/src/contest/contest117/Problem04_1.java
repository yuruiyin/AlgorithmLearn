package contest.contest117;

import common.TreeNode;

public class Problem04_1 {

    private int dp(TreeNode root, boolean isRootNeedInstall, boolean isParentInstall) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null && !isRootNeedInstall) {
            return isParentInstall ? 0 : 1;
        }

        if (isRootNeedInstall) {
            int leftRes = dp(root.left, false, true);
            int rightRes = dp(root.right, false, true);
            return Math.min(leftRes, rightRes) + 1;
        } else {
            // 当前root装
            int installLeftRes = dp(root.left, false, true);
            int installRightRes = dp(root.right, false, true);
            int installMin = Math.min(installLeftRes, installRightRes) + 1;

            // 当前root不装，那么要么左子树根节点装，要么右子树根节点装
            int notInstallLeftRes1 = dp(root.left, true, false);
            int notInstallRightRes1 = dp(root.right, false, false);
            int notInstallMin1 = Math.min(notInstallLeftRes1, notInstallRightRes1);

            int notInstallLeftRes2 = dp(root.left, false, false);
            int notInstallRightRes2 = dp(root.right, true, false);
            int notInstallMin2 = Math.min(notInstallLeftRes2, notInstallRightRes2);

            int notInstallMin = Math.min(notInstallMin1, notInstallMin2);
            return Math.min(installMin, notInstallMin);
        }
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

        if (root.left == null && root.right == null) {
            return 1;
        }

        int installRes = dp(root, true, false);
        int notInstallRes = dp(root, false, false);
        return Math.min(installRes, notInstallRes);
    }

}
