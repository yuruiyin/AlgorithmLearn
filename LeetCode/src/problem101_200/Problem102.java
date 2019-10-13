package problem101_200;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem102 {

    private List<List<Integer>> levels = new ArrayList<>();

    private void getLevels(TreeNode root, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(root.val);

        if (root.left != null) {
            getLevels(root.left, level + 1);
        }

        if (root.right != null) {
            getLevels(root.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrderDfs(TreeNode root) {
        if (root == null) {
            return levels;
        }
        getLevels(root, 0);
        return levels;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levels = new ArrayList<>();

        queue.addLast(root);

        int level = 0;
        while (!queue.isEmpty()) {
            levels.add(new ArrayList<>());

            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.removeFirst();
                levels.get(level).add(node.val);

                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            level++;
        }

        return levels;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> levels = new Problem102().levelOrderDfs(root);
        
        for (List<Integer> list: levels) {
            for (Integer num: list) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
    }

}
