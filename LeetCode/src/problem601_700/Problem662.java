package problem601_700;

import common.TreeNode;

import java.util.LinkedList;

public class Problem662 {

    public int widthOfBinaryTree(TreeNode root) {
        // BFS
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 把val当成idx
        root.val = 1;
        queue.add(root);
        int levelNodeMax = 1;
        while (!queue.isEmpty()) {
            levelNodeMax = Math.max(levelNodeMax, queue.getLast().val - queue.getFirst().val + 1);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int idx = node.val;
                if (node.left != null) {
                    node.left.val = idx * 2;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = idx * 2 + 1;
                    queue.add(node.right);
                }
            }
        }
        return levelNodeMax;
    }

}
