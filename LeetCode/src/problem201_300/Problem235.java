package problem201_300;

import common.TreeNode;

public class Problem235 {

    private TreeNode getAns(TreeNode root, int value1, int value2) {
        if (value1 == root.val || value2 == root.val) {
            return root;
        }

        if (value1 < root.val && value2 > root.val || value1 > root.val && value2 < root.val) {
            return root;
        }


        if (value1 < root.val && value2 < root.val) {
            return getAns(root.left, value1, value2);
        }

        return getAns(root.right, value1, value2);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.left != null && p.left.val == q.val || p.right != null && p.right.val == q.val) {
            return p;
        }

        if (q.left != null && q.left.val == p.val || q.right != null && q.right.val == p.val) {
            return q;
        }

        if (root == null) {
            return null;
        }

        return getAns(root, p.val, q.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        root.left = left;
        root.right = right;

        root.left.right = new TreeNode(2);

        TreeNode commonRoot = new Problem235().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(3));

        System.out.println(commonRoot.val);
    }
    
}
