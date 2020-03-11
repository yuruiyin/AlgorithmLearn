package doubleContest.round21;

import common.TreeNode;

public class Problem03_1 {

    private int ansMax = 0;

    private void dfs(TreeNode root, int pathLen, int dir) {
        ansMax = Math.max(ansMax, pathLen);
        if (root == null) {
            return;
        }

        dfs(root.left, dir == -1 ? 1 : pathLen + 1, -1);
        dfs(root.right, dir == 1 ? 1 : pathLen + 1, 1);
    }

    public int longestZigZag(TreeNode root) {
        dfs(root, 0, -1);
        dfs(root, 0, 1);
        return ansMax - 1;
    }

}
