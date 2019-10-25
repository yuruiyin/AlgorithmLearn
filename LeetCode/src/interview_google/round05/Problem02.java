package interview_google.round05;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem02 {

    private void dfs(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }

        dfs(root.left, ansList);
        ansList.add(root.val);
        dfs(root.right, ansList);
    }

    // 用栈，按照右->中->左的顺序压栈
    private void iteratorVersion(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        if (root.right != null) {
            stack.push(root.right);
            root.right = null;
        }

        stack.push(root);

        if (root.left != null) {
            stack.push(root.left);
            root.left = null;
        }

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();

            if (top.left == null && top.right == null) {
                ansList.add(top.val);
                continue;
            }

            if (top.right != null) {
                stack.push(top.right);
                top.right = null;
            }

            stack.push(top);

            if (top.left != null) {
                stack.push(top.left);
                top.left = null;
            }
        }

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
//        dfs(root, ansList);
        iteratorVersion(root, ansList);
        return ansList;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> ansList = new Problem02().inorderTraversal(root);
        
        for (Integer value: ansList) {
            System.out.print(value + ",");
        }
        System.out.println();
    }
    
}
