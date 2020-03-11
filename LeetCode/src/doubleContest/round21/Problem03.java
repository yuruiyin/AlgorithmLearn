package doubleContest.round21;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Problem03 {

    private Map<String, Integer> memoMap;

    private int ansMax = 0;

    private int dfs(int direction, TreeNode root) {
        if (root == null) {
            return 0;
        }

        String key = root.hashCode() + "_" + direction;

        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int rightMax = 0;
        if (direction == 1) {
            rightMax = dfs(-1, root.right);
        }

        int leftMax = 0;
        if (direction == -1) {
            leftMax = dfs(1, root.left);
        }

        if (leftMax == 0 && rightMax == 0) {
            memoMap.put(key, 1);
            return 1;
        }

        int max = Math.max(leftMax, rightMax) + 1;
        ansMax = Math.max(ansMax, max);
        memoMap.put(key, max);
        return max;
    }

    private void dfs1(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(-1, root);
        dfs(1, root);
        dfs1(root.left);
        dfs1(root.right);
    }

    public int longestZigZag(TreeNode root) {
        memoMap = new HashMap<>();
        dfs1(root);

        if (ansMax == 0) {
            return 0;
        }

        return ansMax - 1;
    }

}
