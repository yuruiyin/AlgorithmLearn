package spring_2021_group;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * B_1
 *
 * @author: yry
 * @date: 2021/4/10
 */
public class B_1 {

    private Map<String, Integer> memoMap;

    private int dfs(TreeNode root, int curK, int k) {
        if (root == null) {
            return 0;
        }

        String key = root.hashCode() * 11L + "," + curK;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        if (curK == 0) {
            int ans = dfs(root.left, k, k) + dfs(root.right, k, k);
            memoMap.put(key, ans);
            return ans;
        }

        int nonRes = dfs(root.left, k, k) + dfs(root.right, k, k);
        int doneMax = 0;
        for (int i = 0; i <= curK - 1; i++) {
            for (int j = 0; j <= curK - 1; j++) {
                if (i + j <= curK - 1) {
                    int sum = dfs(root.left, i, k) + dfs(root.right, j, k);
                    doneMax = Math.max(doneMax, sum);
                }
            }
        }

        int ans = Math.max(nonRes, root.val + doneMax);
        memoMap.put(key, ans);
        return ans;
    }

    public int maxValue(TreeNode root, int k) {
        memoMap = new HashMap<>();
        return dfs(root, k, k);
    }

}
