package spring_2020;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/18
 */
public class B {



    public int numWays(int n, int[][] relations , int k) {
        List<Integer>[] adj = new ArrayList[n];
        for (int[] relation : relations) {
            int v1 = relation[0];
            int v2 = relation[1];
            if (adj[v1] == null) {
                adj[v1] = new ArrayList<>();
            }
            adj[v1].add(v2);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        int level = 0;
        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                List<Integer> nextList = adj[node];
                if (nextList == null) {
                    continue;
                }

                for (Integer next : nextList) {
                    if (level == k && next == n - 1) {
                        ans++;
                    }
                    queue.add(next);
                }
            }

            if (level == k) {
                break;
            }
        }

        return ans;
    }

}
