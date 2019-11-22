package problem101_200;

import common.TreeNode;

public class Problem108 {

    private TreeNode dfs(int[] nums, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
    
    public static void main(String[] args) {

    }
    
}
