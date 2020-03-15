package contest.contest180;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem03 {

    private void inOrder(TreeNode root, List<TreeNode> nodeList) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inOrder(root.left, nodeList);
        }

        nodeList.add(root);

        if (root.right != null) {
            inOrder(root.right, nodeList);
        }
    }

    private TreeNode dfs(List<TreeNode> nodeList, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return nodeList.get(start);
        }

        int mid = (start + end) >>> 1;
        TreeNode root = nodeList.get(mid);
        root.left = dfs(nodeList, start, mid - 1);
        root.right = dfs(nodeList, mid + 1, end);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        inOrder(root, nodeList);

        for (TreeNode node : nodeList) {
            node.left = null;
            node.right = null;
        }

        return dfs(nodeList, 0, nodeList.size() - 1);
    }

}
