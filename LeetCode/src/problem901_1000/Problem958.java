package problem901_1000;

import common.TreeNode;

import java.util.LinkedList;

public class Problem958 {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean hasNull = false;
        while (!queue.isEmpty()) {
            TreeNode front = queue.removeFirst();

            if (front != null) {
                if (hasNull) {
                    // 层次遍历过程中，前面已经存在null了，后面还有节点，就说明这不是一颗完全二叉树
                    return false;
                }

                queue.addLast(front.left);
                queue.addLast(front.right);
            } else {
                hasNull = true;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        // false
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(5);
//        root.right.left = new TreeNode(7);
//        root.right.right = new TreeNode(8);

        // true
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(new Problem958().isCompleteTree(root));

    }
}
