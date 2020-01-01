package contest.contest092;

import common.TreeNode;

public class Problem865 {

    private int maxDepth = 0;
    private int maxDepthCount = 0;
    private int[] depthCountArr;
    private TreeNode ansNode = null;

    private void getMaxDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            depthCountArr[depth]++;
            return;
        }

        getMaxDepth(root.left, depth + 1);
        getMaxDepth(root.right, depth + 1);
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }

        if (ansNode != null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            if (depth == maxDepth) {
                if (maxDepthCount == 1 && ansNode == null) {
                    ansNode = root;
                }
                return 1;
            } else {
                return 0;
            }
        }

        int leftCount = dfs(root.left, depth + 1);
        int rightCount = dfs(root.right, depth + 1);
        if (leftCount + rightCount == maxDepthCount) {
            if (ansNode == null) {
                ansNode = root;
            }
        }
        return leftCount + rightCount;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depthCountArr = new int[501];
        getMaxDepth(root, 0);
        for (int i = 500; i >= 0; i--) {
            if (depthCountArr[i] > 0) {
                maxDepth = i;
                maxDepthCount = depthCountArr[i];
                break;
            }
        }

//        System.out.println("maxDepth: " + maxDepth);
//        System.out.println("maxDepthCount: " + maxDepthCount);
        dfs(root, 0);
        return ansNode;
    }

}
