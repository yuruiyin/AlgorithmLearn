package problem1101_1200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem1136 {

    public int minimumSemesters(int n, int[][] relations) {
        ArrayList<Integer>[] adj = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < relations.length; i++) {
            int v1 = relations[i][0];
            int v2 = relations[i][1];
            adj[v1].add(v2);
        }

        int[] inDegree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> neighbors = adj[i];
            for (int j = 0; j < neighbors.size(); j++) {
                int neighbor = neighbors.get(j);
                inDegree[neighbor]++;
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }

        if (queue.isEmpty()) {
            // 没有入度为0的
            return -1;
        }

        int ans = 0;
        int leftNodeCount = n;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                list.add(queue.removeFirst());
            }

            leftNodeCount -= list.size();

            ans++;

            for (int i = 0; i < list.size(); i++) {
                int v = list.get(i);
                ArrayList<Integer> neighbors = adj[v];
                for (int j = 0; j < neighbors.size(); j++) {
                    int neighbor = neighbors.get(j);
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.addLast(neighbor);
                    }
                }
            }
        }

        return leftNodeCount > 0 ? -1 : ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1136().minimumSemesters(3, new int[][]{
                {1,3},
                {2,3}
        }));
    }
    
}
