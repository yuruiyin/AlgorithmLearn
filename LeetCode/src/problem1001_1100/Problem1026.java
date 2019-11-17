package problem1001_1100;

import common.TreeNode;

public class Problem1026 {

    private int ansMax = 0;

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        if (root.left == null && root.right == null) {
            return new int[]{root.val, root.val};
        }

        int[] leftRes = null;
        if (root.left != null) {
            leftRes = dfs(root.left);
        }

        int[] rightRes = null;
        if (root.right != null) {
            rightRes = dfs(root.right);
        }

        if (leftRes != null) {
            int value1 = Math.abs(leftRes[0] - root.val);
            int value2 = Math.abs(leftRes[1] - root.val);
            int max = Math.max(value1, value2);
            if (max > ansMax) {
                ansMax = max;
            }
        }

        if (rightRes != null) {
            int value1 = Math.abs(rightRes[0] - root.val);
            int value2 = Math.abs(rightRes[1] - root.val);
            int max = Math.max(value1, value2);
            if (max > ansMax) {
                ansMax = max;
            }
        }

        int resMax;
        int resMin;

        if (leftRes != null && rightRes != null) {
            resMin = Math.min(Math.min(leftRes[0], rightRes[0]), root.val);
            resMax = Math.max(Math.max(leftRes[1], rightRes[1]), root.val);
        } else if (leftRes != null) {
            resMin = Math.min(leftRes[0], root.val);
            resMax = Math.max(leftRes[1], root.val);
        } else {
            resMin = Math.min(rightRes[0], root.val);
            resMax = Math.max(rightRes[1], root.val);
        }

        return new int[]{resMin, resMax};
    }

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return ansMax;
    }
    
    public static void main(String[] args) {
        
    }
    
}
