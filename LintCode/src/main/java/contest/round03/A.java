package contest.round03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/3/21
 */
public class A {

    private int max = 0;
    private int[] time;

    private void dfs(List<Integer>[] adj, int cur, int sum) {
        if (adj[cur] == null) {
            max = Math.max(max, sum);
            return;
        }

        for (Integer next: adj[cur]) {
            dfs(adj, next, sum + time[next]);
        }
    }

    class Node {
        int id;
        int pathSum;
        Node(int id, int pathSum) {
            this.id = id;
            this.pathSum = pathSum;
        }
    }

    private void bfs(List<Integer>[] adj) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (adj[cur.id] == null) {
                    // 叶子
                    max = Math.max(max, cur.pathSum);
                    continue;
                }

                for (Integer next: adj[cur.id]) {
                    queue.offer(new Node(next, cur.pathSum + time[next]));
                }
            }
        }
    }

    public int timeToFlowerTree(int[] father, int[] time) {
        // 求最长路径
        int n = father.length;
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            if (father[i] == -1) {
                continue;
            }

            if (adj[father[i]] == null) {
                adj[father[i]] = new ArrayList<>();
            }

            adj[father[i]].add(i);
        }

        this.time = time;
//        dfs(adj, 0, 0);
        bfs(adj);
        return max;
    }

}
