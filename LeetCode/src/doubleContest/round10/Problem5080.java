package doubleContest.round10;

import common.TreeNode;

public class Problem5080 {

    private boolean find(TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (root.val == value) {
            return true;
        } else if (root.val < value) {
            return find(root.right, value);
        } else {
            return find(root.left, value);
        }
    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null) {
            return false;
        }

        // 使用或运算进行短路操作，找到就终止
        return find(root2, target - root1.val) || twoSumBSTs(root1.left, root2, target) ||
                twoSumBSTs(root1.right, root2, target);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);

        System.out.println(new Problem5080().twoSumBSTs(root1, root2, 5));
    }
}
