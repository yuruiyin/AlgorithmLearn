import interview_tencent.round02.Problem01;

import java.util.ArrayList;
import java.util.List;

public class Problem094 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void recursive(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            recursive(root.left, ansList);
        }

        ansList.add(root.val);

        if (root.right != null) {
            recursive(root.right, ansList);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        recursive(root, ansList);
        return ansList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> ansList = new Problem094().inorderTraversal(root);

        for (int item : ansList) {
            System.out.print(item + " ");
        }
    }
}
