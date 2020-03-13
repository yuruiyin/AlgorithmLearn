package problem501_600;

import common.TreeNode;
import utils.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem515 {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> ansList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ansList.add(max);
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        List<Integer> ansList = new Problem515().largestValues(root);
        PrintUtil.printIntList(ansList);
    }

}
