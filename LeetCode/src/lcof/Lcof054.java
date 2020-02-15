package lcof;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Lcof054 {

    private List<Integer> valList;

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        valList.add(root.val);
        inorder(root.right);
    }

    public int kthLargest(TreeNode root, int k) {
        valList = new ArrayList<>();
        inorder(root);
        return valList.get(valList.size() - k);
    }

}
