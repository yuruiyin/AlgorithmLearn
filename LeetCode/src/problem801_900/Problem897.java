package problem801_900;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem897 {

    private List<TreeNode> list;

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            TreeNode node = list.get(i);
            node.left = null;
            node.right = list.get(i+1);
        }

        list.get(size - 1).left = null;
        list.get(size - 1).right = null;

        return list.get(0);
    }

}
