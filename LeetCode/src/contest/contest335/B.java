package contest.contest335;

import common.TreeNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class B {

    public long kthLargestLevelSum(TreeNode root, int k) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        PriorityQueue<Long> heap = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return Long.compare(o1, o2);
            }
        });

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            heap.add(sum);
            if (heap.size() > k) {
                heap.poll();
            }
        }


        return heap.size() < k ? -1 : heap.peek();
    }

}
