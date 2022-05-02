package spring_2022_group;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class F {

    private int[] levelSumArr;

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        levelSumArr[level] += root.val;
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    private int getMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < 100001; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private Map<TreeNode, int[]> memo;

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return new int[]{root.val};
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int leftSize = left == null ? 0 : left.length;
        int rightSize = right == null ? 0 : right.length;
        int ansSize = 1 + Math.max(leftSize, rightSize);
        int[] res = new int[ansSize];
        res[0] = root.val;
        for (int i = 0; i < ansSize - 1; i++) {
            int leftNum = 0;
            if (left != null && i < leftSize) {
                leftNum = left[i];
            }
            int rightNum = 0;
            if (right != null && i < rightSize) {
                rightNum = right[i];
            }
            res[i + 1] = leftNum + rightNum;
        }

        memo.put(root, res);

        return res;
    }

    private void dfs1(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right != null) {
            int[] oldArr = memo.get(root);
            int[] arr = memo.get(root.right);

        }
    }

    public int getMaxLayerSum(TreeNode root) {
        levelSumArr = new int[100001];
        dfs(root, 0);
        int ansMax = getMax(levelSumArr);

        memo = new HashMap<>();
        dfs(root);
        // todo
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
