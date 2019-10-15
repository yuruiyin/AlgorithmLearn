package interview_bytedance.round04;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem01 {

    private void preorder(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }

        ansList.add(root.val);
        preorder(root.left, ansList);
        preorder(root.right, ansList);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        preorder(root, ansList);
        return ansList;
    }
    
    public static void main(String[] args) {
        
    }
    
}
