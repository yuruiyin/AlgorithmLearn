package problem801_900;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem863 {

    private List<Integer>[] adj;

    private List<Integer> getAns(int target, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(target);

        int dis = 0;
        boolean[] visited = new boolean[501];
        visited[target] = true;
        List<Integer> ansList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ansList.clear();
            for (int i = 0; i < size; i++) {
                Integer front = queue.poll();
                ansList.add(front);
                for (Integer next : adj[front]) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.offer(next);
                }
            }

            if (dis == k) {
                return ansList;
            }

            dis++;
        }

        return new ArrayList<>();
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) {
            return new ArrayList<>();
        }

        adj = new ArrayList[501];
        for (int i = 0; i < 501; i++) {
            adj[i] = new ArrayList<>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode front = queue.poll();
                if (front.left != null) {
                    adj[front.val].add(front.left.val);
                    adj[front.left.val].add(front.val);
                    queue.offer(front.left);
                }

                if (front.right != null) {
                    adj[front.val].add(front.right.val);
                    adj[front.right.val].add(front.val);
                    queue.offer(front.right);
                }
            }
        }

        return getAns(target.val, k);
    }

}
