package doubleContest.round21;

import common.TreeNode;

public class Problem04 {

    class Result {
        int sum;
        int min;
        int max;
        boolean isBst;
        Result(int sum, int min, int max, boolean isBst) {
            this.sum = sum;
            this.min = min;
            this.max = max;
            this.isBst = isBst;
        }
    }

    private int ansMaxSum = 0;

    private Result dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        Result leftRes = dfs(root.left);
        Result rightRes = dfs(root.right);
        int resSum = root.val;
        int resMin = root.val;
        int resMax = root.val;
        boolean resIsBst = true;

        if (leftRes != null) {
            resSum += leftRes.sum;
            resMin = Math.min(resMin, leftRes.min);
            resMax = Math.max(resMax, leftRes.max);
            resIsBst = leftRes.isBst && leftRes.max < root.val;
        }

        if (rightRes != null) {
            resSum += rightRes.sum;
            resMin = Math.min(resMin, rightRes.min);
            resMax = Math.max(resMax, rightRes.max);
            resIsBst = resIsBst && rightRes.isBst && rightRes.min > root.val;
        }

        if (resIsBst) {
            ansMaxSum = Math.max(ansMaxSum, resSum);
        }

        return new Result(resSum, resMin, resMax, resIsBst);
    }

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ansMaxSum;
    }

}
