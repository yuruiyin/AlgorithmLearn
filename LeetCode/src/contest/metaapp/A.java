package contest.metaapp;

import java.util.LinkedList;

public class A {

//    1 <= bombs.length <= 100
//    bombs[i].length == 3
//            1 <= xi, yi, ri <= 105

    private int bfs(int[][] bombs, int cur) {
        int len = bombs.length;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(cur);
        boolean[] visited = new boolean[len];
        visited[cur] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                long x1 = bombs[node][0];
                long y1 = bombs[node][1];
                long r1 = bombs[node][2];
                for (int j = 0; j < len; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    long x2 = bombs[j][0];
                    long y2 = bombs[j][1];
                    long r2 = bombs[j][2];
                    long diff = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                    if (diff < (r1 + r2) * (r1 + r2)) {
                        visited[j] = true;
                        ans++;
                        queue.add(j);
                    }
                }
            }
        }
        return ans;
    }

    public int maximumDetonation(int[][] bombs) {
        int len = bombs.length;
        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            ansMax = Math.max(ansMax, bfs(bombs, i));
        }
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
