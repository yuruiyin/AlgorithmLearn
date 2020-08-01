package dianfeng_contest.S107;

import java.util.ArrayList;
import java.util.List;

public class B {

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private List<Integer>[] adj;
    private int[] f;

    private int dfs(int cur, int k, boolean[] visited) {
        visited[cur] = true;

        if (f[cur - 1] == 1) {
            k--;
        }

        if (k < 0) {
            return 0;
        }

        // 是否叶子节点
        List<Integer> nextList = adj[cur];
        if (nextList.size() == 1 &&  visited[nextList.get(0)]) {
            return 1;
        }

        int ans = 0;
        for (Integer next : nextList) {
            if (visited[next]) {
                continue;
            }

            ans += dfs(next, k, visited);
        }

        return ans;
    }

    /**
     * 返回牛牛能到达终点且不被淘汰的路径数
     * @param n int整型
     * @param edges Point类一维数组
     * @param f int整型一维数组
     * @return int整型
     */
    public int solve (int n, Point[] edges, int[] f) {
        // write code here
        adj = new ArrayList[n + 1];
        this.f = f;

        if (n == 1) {
            return 1;
        }

        for (Point edge : edges) {
            int u = edge.x;
            int v = edge.y;
            if (adj[u] == null) {
                adj[u] = new ArrayList<>();
            }
            adj[u].add(v);

            if (adj[v] == null) {
                adj[v] = new ArrayList<>();
            }
            adj[v].add(u);
        }

        return dfs(1, 2, new boolean[n + 1]);
    }

    public static void main(String[] args) {
//        Point[] edges = new Point[4];
//        edges[0] = new Point(1, 2);
//        edges[1] = new Point(1, 3);
//        edges[2] = new Point(4, 2);
//        edges[3] = new Point(2, 5);
//        System.out.println(new B().solve(5, edges, new int[]{1,1,1,0,0}));

        Point[] edges = new Point[0];
        System.out.println(new B().solve(1, edges, new int[]{1}));
    }

}
