package contest.contest115;

import common.TreeNode;

import java.util.LinkedList;

public class Problem958 {

    private int calcLeftChildDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        return calcLeftChildDepth(root.left, depth + 1);
    }

    private int calcRightChildDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        return calcRightChildDepth(root.right, depth + 1);
    }

    private boolean levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.addLast(root);

        boolean ifJustRightNull = false;
        boolean isLeftRightAllNull = false;
        while (!queue.isEmpty()) {
            TreeNode front = queue.removeFirst();

            if(front.right != null && front.left == null) {
                return false;
            }

            if (front.left != null) {
                if (ifJustRightNull || isLeftRightAllNull) {
                    return false;
                }
                queue.addLast(front.left);
            }

            if (front.right != null) {
                if (ifJustRightNull || isLeftRightAllNull) {
                    return false;
                }
                queue.addLast(front.right);
            }

            if (front.left != null && front.right == null) {
                ifJustRightNull = true;
            }

            if (front.left == null && front.right == null) {
                isLeftRightAllNull = true;
            }
        }

        return true;
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }

        int leftDepth = calcLeftChildDepth(root, 0);
        int rightDepth = calcRightChildDepth(root, 0);

        if (leftDepth > rightDepth + 1 || leftDepth < rightDepth) {
            return false;
        }

        return levelOrder(root);
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
