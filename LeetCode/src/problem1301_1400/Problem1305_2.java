package problem1301_1400;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem1305_2 {

    private PriorityQueue<Integer> priorityQueue;

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        priorityQueue.offer(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        priorityQueue = new PriorityQueue<>();
        dfs(root1);
        dfs(root2);
        List<Integer> ansList = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            ansList.add(priorityQueue.poll());
        }
        return ansList;
    }

}
