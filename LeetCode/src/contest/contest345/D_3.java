package contest.contest345;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class D_3 {

//    private final static int[] queue = new int[50];

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
//        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (adj[u] == null) {
                adj[u] = new ArrayList<>();
            }
            adj[u].add(v);

            if (adj[v] == null) {
                adj[v] = new ArrayList<>();
            }
            adj[v].add(u);
        }

        int[] queue = new int[n];
        long nodeVisited = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if ((nodeVisited & (1L << i)) != 0) {
                continue;
            }

            if (adj[i] == null) {
                ans++;
                continue;
            }

            nodeVisited |= 1L << i;
            queue[0] = i;
            int curIdx = 0;
            int queueSize = 1;
            int nodeCount = 0;
            int edgeCount = 0;
            boolean isOk = true;
            while (curIdx < queueSize) {
                int node = queue[curIdx++];
                nodeCount++;

                List<Integer> nextList = adj[node];
                if (edgeCount == 0) {
                    edgeCount = nextList.size();
                } else {
                    if (isOk && (edgeCount < nodeCount - 1 || edgeCount != nextList.size())) {
                        isOk = false;
                    }
                }
                for (int next : nextList) {
                    if ((nodeVisited & (1L << next)) != 0) {
                        continue;
                    }
                    nodeVisited |= 1L << next;
                    queue[queueSize++] = next;
                }
            }

            if (isOk && edgeCount == nodeCount - 1) {
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
        System.out.println(new D_3().countCompleteComponents(4, new int[][]{
                {2,0},{3,1},{3,2}
        }));

    }

}
