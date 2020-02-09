package contest.contest174;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Problem03 {

    private static final int MOD = 1000000007;
    private long sum = 0;

    private Map<TreeNode, Long> map;
    private long ansMax = Long.MIN_VALUE;
    private TreeNode totalRoot;

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        sum += root.val;
        dfs(root.left);
        dfs(root.right);
    }

    private long getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        long left = getSum(root.left);
        long right = getSum(root.right);
        long sum = left + right + root.val;
        map.put(root, sum);
        return sum;
    }

    private void dfs1(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root != totalRoot) {
            long sum1 = map.get(root);
            long sum2 = sum - sum1;
            ansMax = Math.max(ansMax, sum1 * sum2);
        }

        dfs1(root.left);
        dfs1(root.right);
    }

    public int maxProduct(TreeNode root) {
        totalRoot = root;
        dfs(root);
        map = new HashMap<>();
        getSum(root);

        dfs1(root);
        return (int) (ansMax % MOD);
    }

}
