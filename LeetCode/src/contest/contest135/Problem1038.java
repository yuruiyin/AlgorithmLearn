package contest.contest135;

import common.TreeNode;

import java.util.LinkedList;

public class Problem1038 {

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + getSum(root.left) + getSum(root.right);
    }

    private int dfs(TreeNode root, LinkedList<Integer> valueList, int parentSum) {
        if (root == null) {
            return 0;
        }

        int leftSum = dfs(root.left, valueList, parentSum);
        valueList.addLast(leftSum + parentSum);
        int rightSum = dfs(root.right, valueList, leftSum + parentSum + root.val);

        return root.val + leftSum + rightSum;
    }

    private void changeTree(TreeNode root, LinkedList<Integer> valueList, int sum) {
        if (root == null) {
            return;
        }

        changeTree(root.left, valueList, sum);
        root.val = sum - valueList.removeFirst();
        changeTree(root.right, valueList, sum);
    }

    public TreeNode bstToGst(TreeNode root) {
        int sum = getSum(root);
        LinkedList<Integer> valueList = new LinkedList<>();
        dfs(root, valueList, 0);
        changeTree(root, valueList, sum);
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        new Problem1038().bstToGst(root);


    }
}
