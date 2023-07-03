package contest.contest345;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_4 {

    // 超快版本 并查集 4ms
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] listArr = new ArrayList[n];
        Arrays.setAll(listArr, value -> new ArrayList<>(n));
        int[] degree = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
            if (!listArr[u].isEmpty() && !listArr[v].isEmpty()) {
                if (listArr[u] == listArr[v]) {
                    continue;
                }
                if (listArr[u].size() < listArr[v].size()) {
                    listArr[v].addAll(listArr[u]);
                    for (int node : listArr[u]) {
                        listArr[node] = listArr[v];
                    }
                } else {
                    listArr[u].addAll(listArr[v]);
                    for (int node : listArr[v]) {
                        listArr[node] = listArr[u];
                    }
                }
            } else if (!listArr[u].isEmpty()) {
                listArr[u].add(v);
                listArr[v] = listArr[u];
            } else if (!listArr[v].isEmpty()) {
                listArr[v].add(u);
                listArr[u] = listArr[v];
            } else {
                listArr[u].add(u);
                listArr[u].add(v);
                listArr[v] = listArr[u];
            }
        }

        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            List<Integer> list = listArr[i];
            if (list.isEmpty()) {
                ans++;
                continue;
            }

            int nodeCount = list.size();
            boolean isOk = true;
            for (int node : list) {
                if (isOk && degree[node] != nodeCount - 1) {
                    isOk = false;
                }
                visited[node] = true;
            }
            if (isOk) {
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
        System.out.println(new D_4().countCompleteComponents(4, new int[][]{
                {2,0},{3,1},{3,2}
        }));

    }

}
