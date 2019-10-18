package problem001_100;

import common.TreeNode;

public class Problem098 {

    /**
     * 判断是否为合法的BST
     * @param root
     * @return  int[以当前节点为root的树的所有节点最小值，以当前节点为root的树的所有节点最大值，是否是一颗有效的BST，1-是，0-不是]
     */
    private int[] isValid(TreeNode root) {
        int min = root.val;
        int max = root.val;
        if (root.left != null) {
            int[] leftRes = isValid(root.left);
            if (leftRes[2] == 0 || leftRes[1] >= root.val) {
                return new int[]{0, 0, 0};
            }

            min = leftRes[0];
        }

        if (root.right != null) {
            int[] rightRes = isValid(root.right);
            if (rightRes[2] == 0 || rightRes[0] <= root.val) {
                return new int[]{0, 0, 0};
            }

            max = rightRes[1];
        }

        return new int[]{min, max, 1};
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        int[] res = isValid(root);
        return res[2] == 1;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        
        System.out.println(new Problem098().isValidBST(root));

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);

        System.out.println(new Problem098().isValidBST(root1));

        TreeNode root2 = new TreeNode(24);
        root2.left = new TreeNode(-60);
        root2.left.left = new TreeNode(-60);
        root2.left.right = new TreeNode(-6);

        System.out.println(new Problem098().isValidBST(root2));
    }
    
}
