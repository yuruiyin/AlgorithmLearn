package problem1201_1300;

import java.util.ArrayList;
import java.util.List;

public class Problem1273 {

    private int[] dfs(List<Integer>[] adj, int from, int[] value) {
        if (adj[from].isEmpty()) {
            // 叶子
            if (value[from] == 0) {
                return new int[]{0, 0};
            } else {
                return new int[]{1, value[from]};
            }
        }

        int curNodeValue = value[from];
        List<Integer> neighbors = adj[from];
        int remainingCount = 1;
        int sum = curNodeValue;

        for (Integer node: neighbors) {
            int[] res = dfs(adj, node, value);
            remainingCount += res[0];
            sum += res[1];
        }

        if (sum == 0) {
            remainingCount = 0;
        }

        return new int[]{remainingCount, sum};
    }

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        if (nodes == 1) {
            if (value[0] == 0) {
                return 0;
            } else {
                return 1;
            }
        }

        List<Integer>[] adj = new ArrayList[nodes];

        for (int i = 0; i < nodes; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < parent.length; i++) {
            adj[parent[i]].add(i);
        }

        int[] res = dfs(adj, 0, value);
        return res[0];
    }
    
    public static void main(String[] args) {
        
    }
    
}
