package problem101_200;

import common.TreeNode;

public class Problem124 {

    private int ansMax = Integer.MIN_VALUE;

    /**
     * 思路：计算左右子树的最大路径和，由于当前路径和可能为负数，因此当前节点可以根据情况选择是否要考虑左右子树的最大路径和。这里分为四种情况：
     * （1）都不考虑左右子树
     * （2）只考虑左子树
     * （3）只考虑右子树
     * （4）左右子树都考虑
     * 然后就去以上四种情况的最大值去更新全局的最大路径和。
     *
     * 这个递归函数返回的是以当前节点为根的子树，并包含根节点的路径和最大值。
     *
     * @param root 当前节点
     * @return
     */
    private int getMax(TreeNode root) {
        if (root.left == null && root.right == null) {
            // 叶子
            if (root.val > ansMax) {
                ansMax = root.val;
            }
            return root.val;
        }

        int leftMax = 0;
        if (root.left != null) {
            leftMax = getMax(root.left);
        }

        int rightMax = 0;
        if (root.right != null) {
            rightMax = getMax(root.right);
        }

        int tmpMax = Math.max(Math.max(root.val, root.val + leftMax), Math.max(root.val + rightMax, root.val + leftMax + rightMax));
        if (tmpMax > ansMax) {
            ansMax = tmpMax;
        }

        return Math.max(root.val, root.val + Math.max(leftMax, rightMax));
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        getMax(root);

        return ansMax;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Problem124().maxPathSum(root));

        TreeNode root1 = new TreeNode(-10);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(new Problem124().maxPathSum(root1));

        TreeNode root2 = new TreeNode(-3);
        System.out.println(new Problem124().maxPathSum(root2));

        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(-1);
        System.out.println(new Problem124().maxPathSum(root3));
    }
    
}
