package problem201_300;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem272 {

    private PriorityQueue<Data> priorityQueue;
    private double target;
    private int k;

    class Data {
        double diff;    // 差值
        int nodeVal; // 原节点值
        Data(double diff, int nodeVal) {
            this.diff = diff;
            this.nodeVal = nodeVal;
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        double diff = Math.abs(root.val - target);
        priorityQueue.add(new Data(diff, root.val));
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        dfs(root.left);
        dfs(root.right);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        this.target = target;
        this.k = k;
        priorityQueue = new PriorityQueue<>(k, (o1, o2) -> Double.compare(o2.diff, o1.diff));
        dfs(root);

        List<Integer> ansList = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            Data data = priorityQueue.poll();
            ansList.add(data.nodeVal);
        }
        return ansList;
    }

}
