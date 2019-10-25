package interview_google.round06;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem01 {

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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        preOrder(root1, list1);
        preOrder(root2, list2);

        return list1.equals(list2);
    }
    
    public static void main(String[] args) {

    }
    
}
