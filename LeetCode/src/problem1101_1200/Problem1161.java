package problem1101_1200;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem1161 {

    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        List<Integer> sumList = new ArrayList<>();

        while (!queue.isEmpty()) {
            List<TreeNode> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.removeFirst());
            }

            int sum  = 0;
            for (TreeNode node: nodeList) {
                sum += node.val;
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }

            sumList.add(sum);
        }

        int max = Integer.MIN_VALUE;
        int maxSumMinIndex = -1;
        for (int i = 0; i < sumList.size(); i++) {
            if (sumList.get(i) > max) {
                max = sumList.get(i);
                maxSumMinIndex = i;
            }
        }

        return maxSumMinIndex + 1;
    }
    
    public static void main(String[] args) {
        
    }
}
