package lcof;

import common.TreeNode;

public class Lcof054_1 {

    private int index = 0;
    private int ans;

    private void dfs(TreeNode root, int k) {
        if (root == null || index >= k) {
            return;
        }

        dfs(root.right, k);
        index++;
        if (index == k) {
            ans = root.val;
            return;
        }
        dfs(root.left, k);
    }

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

}
