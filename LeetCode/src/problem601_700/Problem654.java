package problem601_700;

import common.TreeNode;

public class Problem654 {

    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(nums[l]);
        }

        int maxNum = 0;
        int maxNumIdx = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] >= maxNum) {
                maxNum = nums[i];
                maxNumIdx = i;
            }
        }
        TreeNode cur = new TreeNode(maxNum);
        cur.left = dfs(nums, l, maxNumIdx - 1);
        cur.right = dfs(nums, maxNumIdx + 1, r);
        return cur;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

}
