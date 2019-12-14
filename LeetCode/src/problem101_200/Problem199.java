package problem101_200;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem199 {

    private void bfs(TreeNode root, List<Integer> ansList) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<TreeNode> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.removeFirst());
            }

            ansList.add(nodeList.get(nodeList.size() - 1).val);

            for (TreeNode node : nodeList) {
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        if (root == null) {
            return ansList;
        }

        bfs(root, ansList);
        return ansList;
    }

}
