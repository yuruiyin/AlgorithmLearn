package interview_microsoft.round01;

import common.TreeNode;

public class Problem02 {

    /**
     * 获取最大的BST，BST的要求是左子树的所有节点大小都小于当前节点，而右子树的所有节点大小都大于当前节点，
     * 这里其实就是要满足左子树的所有节点最大值小于当前节点值，而右子树的所有节点最小值都要大于当前节点值。
     * 思路：开辟一个四个元素的数组，四个元素的含义分别如下：
     * 1. 若以当前节点为root是一颗BST,则该值为当前BST的节点数，否则，值为0，代表当前节点为root不是一个BST。
     * 2. 若以当前节点为root是一颗BST，则该位置存放BST的节点最大值
     * 3. 若以当前节点为root是一颗BST，则该位置存放BST的节点最小值
     * 4. 将遍历过程的最大BST的节点数保存到这个位置上。
     * @param root
     * @return int[4]
     */
    private int[] getLargestBST(TreeNode root) {
        if (root.left == null && root.right == null) {
            // 叶子节点
            return new int[]{1, root.val, root.val, 1};
        }

        boolean isLeftBST = true;
        boolean isRightBST = true;
        int[] leftRes = new int[4];
        int[] rightRes = new int[4];
        boolean hasLeft = false;
        boolean hasRight = false;
        if (root.left != null) {
            hasLeft = true;
            leftRes = getLargestBST(root.left);
            if (leftRes[0] == 0) {
                // 左子树是一颗BST
                isLeftBST = false;
            }
        }

        if (root.right != null) {
            hasRight = true;
            rightRes = getLargestBST(root.right);
            if (rightRes[0] == 0) {
                // 左子树不是一颗BST
                isRightBST = false;
            }
        }

        if (!isLeftBST || !isRightBST) {
            return new int[]{0, 0, 0, Math.max(leftRes[3], rightRes[3])};
        }

        boolean isLeftOk = true;
        boolean isRightOk = true;
        if (hasLeft && leftRes[1] >= root.val) {
            isLeftOk = false;
        }

        if (hasRight && rightRes[2] <= root.val) {
            isRightOk = false;
        }

        if (isLeftOk && isRightOk) {
            int[] res = new int[4];
            res[0] = leftRes[0] + rightRes[0] + 1;
            res[1] = hasRight ? rightRes[1] : root.val;
            res[2] = hasLeft ? leftRes[2] : root.val;
            res[3] = res[0];

            return res;
        }

        int curMaxSize = Math.max(leftRes[3], rightRes[3]);

        return new int[]{0, 0, 0, curMaxSize};
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] res = getLargestBST(root);

        return res[3];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(1);

        System.out.println(new Problem02().largestBSTSubtree(root));
    }

}
