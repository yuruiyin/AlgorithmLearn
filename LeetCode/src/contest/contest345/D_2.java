package contest.contest345;

import java.util.*;

public class D_2 {

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] edgeVisited = new boolean[n * n + 1];
        long nodeVisited = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if ((nodeVisited & (1L << i)) != 0) {
                continue;
            }

            nodeVisited |= 1L << i;
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(i);
            int nodeCount = 0;
            int edgeCount = 0;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                nodeCount++;

                List<Integer> nextList = adj[node];
                for (int next : nextList) {
                    int edgeFlag1 = node * n + next;
                    int edgeFlag2 = next * n + node;
                    if (edgeVisited[edgeFlag1] || edgeVisited[edgeFlag2]) {
                        continue;
                    }
                    edgeCount++;
                    edgeVisited[edgeFlag1] = true;
                    edgeVisited[edgeFlag2] = true;
                    if ((nodeVisited & (1L << next)) != 0) {
                        continue;
                    }
                    nodeVisited |= 1L << next;
                    queue.add(next);
                }
            }

            if (edgeCount == (nodeCount * (nodeCount - 1) >> 1)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // 4
        //[[2,1],[3,0],[3,1],[3,2]]
//        System.out.println(new D().countCompleteComponents(4, new int[][]{
//                {2,1},{3,0},{3,1},{3,2}
//        }));

//        System.out.println(new D().countCompleteComponents(4, new int[][]{
//                {2,1},{3,0}
//        }));


//        4
//                [[2,0],[3,1],[3,2]]
        System.out.println(new D_2().countCompleteComponents(4, new int[][]{
                {2,0},{3,1},{3,2}
        }));

    }

}
