package problem201_300;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem230 {

    private List<Integer> inOrderList;

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        inOrderList.add(root.val);
        inOrder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        inOrderList = new ArrayList<>();
        inOrder(root);

        return inOrderList.get(k-1);
    }

}
