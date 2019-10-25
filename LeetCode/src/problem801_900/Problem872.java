package problem801_900;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem872 {

    private void preOrder(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            ansList.add(root.val);
        }

        if (root.left != null) {
            preOrder(root.left, ansList);
        }

        if (root.right != null) {
            preOrder(root.right, ansList);
        }
    }

    private void preOrderByIterator(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            ansList.add(root.val);
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        if (root.right != null) {
            stack.push(root.right);
        }

        if (root.left != null) {
            stack.push(root.left);
        }

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();

            if (top.left == null && top.right == null) {
                ansList.add(top.val);
                continue;
            }

            if(top.right != null) {
                stack.push(top.right);
            }

            if (top.left != null) {
                stack.push(top.left);
            }

        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

//        preOrder(root1, list1);
//        preOrder(root2, list2);
        preOrderByIterator(root1, list1);
        preOrderByIterator(root2, list2);

        return list1.equals(list2);
    }

    public static void main(String[] args) {

    }


}
