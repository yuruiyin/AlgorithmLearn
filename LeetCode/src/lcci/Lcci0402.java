package lcci;

import common.TreeNode;

public class Lcci0402 {

    private int[] nums;

    private TreeNode dfs(int start, int end) {
        if (end < start) {
            return null;
        }

        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int mid = (start + end + 1) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(start, mid - 1);
        root.right = dfs(mid + 1, end);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return dfs(0, nums.length - 1);
    }

}
