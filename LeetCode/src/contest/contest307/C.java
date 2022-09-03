package contest.contest307;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class C {

    private List<Integer>[] adj;

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        TreeNode left = cur.left;
        TreeNode right = cur.right;
        if (left != null) {
            adj[cur.val].add(left.val);
            adj[left.val].add(cur.val);
            dfs(left);
        }
        if (right != null) {
            adj[cur.val].add(right.val);
            adj[right.val].add(cur.val);
            dfs(right);
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        adj = new ArrayList[100001];
        Arrays.setAll(adj, value -> new ArrayList<>());
        dfs(root);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[100001];
        visited[start] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                List<Integer> nextList = adj[cur];
                for (int next : nextList) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.add(next);
                }
            }
            ans++;
        }
        return ans - 1;
    }

}
