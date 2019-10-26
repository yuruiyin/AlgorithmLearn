package problem1101_1200;

import common.TreeNode;

public class Problem1145 {

    private int calcNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + calcNodeCount(root.left) + calcNodeCount(root.right);
    }

    private int calcChildTreeNodeCount(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }

        if (root.val == x) {
            return calcNodeCount(root);
        }

        int leftRes = calcChildTreeNodeCount(root.left, x);
        int rightRes = calcChildTreeNodeCount(root.right, x);
        return Math.max(leftRes , rightRes);
    }

    private int calcLeftChildNodeCount(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }

        if (root.val == x) {
            return calcNodeCount(root.left);
        }

        int leftRes = calcLeftChildNodeCount(root.left, x);
        int rightRes = calcLeftChildNodeCount(root.right, x);
        return Math.max(leftRes , rightRes);
    }

    private int calcRightChildNodeCount(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }

        if (root.val == x) {
            return calcNodeCount(root.right);
        }

        int leftRes = calcRightChildNodeCount(root.left, x);
        int rightRes = calcRightChildNodeCount(root.right, x);
        return Math.max(leftRes , rightRes);
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int totalCount = calcNodeCount(root);
        int xTreeNodeCount = calcChildTreeNodeCount(root, x);

        if (totalCount - xTreeNodeCount > xTreeNodeCount) {
            return true;
        }

        if (totalCount == xTreeNodeCount) {
            int leftCount = calcLeftChildNodeCount(root, x);
            int rightCount = calcRightChildNodeCount(root, x);

            if (Math.abs(leftCount - rightCount) <= 1) {
                return false;
            } else {
                return true;
            }
        } else {
            int leftCount = calcLeftChildNodeCount(root, x);
            int rightCount = calcRightChildNodeCount(root, x);

            int minCount = Math.min(leftCount, rightCount);
            int maxCount = Math.max(leftCount, rightCount);

            if (maxCount > minCount + 1 + totalCount - xTreeNodeCount) {
                return true;
            }

            return false;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(1);
        System.out.println(new Problem1145().btreeGameWinningMove(root, 5, 2));

//        TreeNode root = new TreeNode(6);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(7);
//        root.left.right = new TreeNode(4);
//        root.left.right.right = new TreeNode(2);
//        root.left.right.right.right = new TreeNode(1);
//        root.left.right.right.right.right = new TreeNode(5);
//
//        System.out.println(new Problem1145().btreeGameWinningMove(root, 7, 3));

    }
    
}
