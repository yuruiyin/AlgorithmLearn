package interview_facebook.round01;

import common.TreeNode;

import java.util.LinkedList;

public class Problem02 {

    private void insertRight(TreeNode root, int val) {
        if (root == null) {
            return;
        }

        TreeNode cursor = root;

        while (true) {
            if (cursor.right != null) {
                if (val > cursor.right.val) {
                    cursor.right = reRoot(cursor.right, val);
                    return;
                }
                cursor = cursor.right;
            } else {
                break;
            }
        }

       cursor.right = new TreeNode(val);
    }

    private TreeNode reRoot(TreeNode root, int val) {
        TreeNode newRoot = new TreeNode(val);
        newRoot.left = root;
        return newRoot;
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (val > root.val) {
            return reRoot(root, val);
        }

        insertRight(root, val);
        return root;
    }

    private void printTreeNode(LinkedList<TreeNode> queue) {
        while (!queue.isEmpty()) {
            TreeNode front = queue.removeFirst();
            if (front == null) {
                System.out.print("null, ");
            } else {
                System.out.print(front.val + ", ");
            }
            if (front != null) {
                queue.addLast(front.left);
            }

            if (front != null) {
                queue.addLast(front.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);

        TreeNode ans = new Problem02().insertIntoMaxTree(root, 5);

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(ans);
        new Problem02().printTreeNode(queue);
    }

}
