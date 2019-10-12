package interview_alibaba.round02;

import common.TreeNode;

public class Problem01 {

    private int max = 1;

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, -1};
        }

        int[] leftRes = new int[]{0, 0};
        int[] rightRes = new int[]{0, 0};
        if (root.left != null) {
            leftRes = dfs(root.left);
        }

        if (root.right != null) {
            rightRes = dfs(root.right);
        }

        if (leftRes[1] == 0 && rightRes[1] == 0) {
            // 叶子节点
            return new int[]{root.val, 1};
        }

        int[] res = new int[]{root.val, 1};
        boolean isLeftSame = false;
        boolean isRightSame = false;
        if (leftRes[1] != 0 && leftRes[0] == root.val) {
            res[1] += leftRes[1];
            isLeftSame = true;
        }

        if (rightRes[1] != 0 && rightRes[0] == root.val) {
            res[1] += rightRes[1];
            isRightSame = true;
        }

        if (res[1] > max) {
            max = res[1];
        }

        if (isLeftSame && isRightSame) {
            res[1] = 1 + Math.max(leftRes[1], rightRes[1]);
        }

        return res;
    }

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max - 1;
    }
    
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(1);
//        root.right.right = new TreeNode(5);
//

//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(1);
//        root.right.left = new TreeNode(1);
//        root.right.right = new TreeNode(1);
//        root.right.left.left = new TreeNode(1);
//        root.right.left.right= new TreeNode(1);
//        root.right.right.left = new TreeNode(1);

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(1);


        System.out.println(new Problem01().longestUnivaluePath(root));

    }
    
}
