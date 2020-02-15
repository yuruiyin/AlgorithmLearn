package lcof;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Lcof026 {

    private void recursive(TreeNode root, int val, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        if (root.val == val) {
            list.add(root);
        }

        recursive(root.left, val, list);
        recursive(root.right, val, list);
    }

    private boolean isMatch(TreeNode rootB, TreeNode nodeA) {
        if (rootB == null) {
            return true;
        }

        if (nodeA == null) {
            return false;
        }

        return rootB.val == nodeA.val && isMatch(rootB.left, nodeA.left) && isMatch(rootB.right, nodeA.right);
    }

    public boolean isSubStructure(TreeNode rootA, TreeNode rootB) {
        if (rootA == null || rootB == null) {
            return false;
        }

        int rootBVal = rootB.val;
        List<TreeNode> firstNodeList = new ArrayList<>();
        recursive(rootA, rootBVal, firstNodeList);

        for (TreeNode node : firstNodeList) {
            boolean isFound = isMatch(rootB, node);
            if (isFound) {
                return true;
            }
        }

        return false;
    }

    public boolean isSubStructure(TreeNode rootA) {
        return false;
    }

}
