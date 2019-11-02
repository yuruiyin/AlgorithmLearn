package doubleContest.round04;

import common.TreeNode;

public class Problem1120 {

    private double ansMax = 0;

    private double[] dfs(TreeNode root) {
        if (root == null) {
            return new double[]{0,0};
        }

        double[] leftRes = dfs(root.left);
        double[] rightRes = dfs(root.right);

        double nodeCount = leftRes[0] + rightRes[0] + 1;
        double sum = leftRes[1] + rightRes[1] + root.val;

        if (sum / nodeCount > ansMax) {
            ansMax = sum / nodeCount;
        }

        return new double[]{nodeCount, sum};
    }

    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return ansMax;
    }
    
    public static void main(String[] args) {
        
    }
    
}
