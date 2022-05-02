package contest.contest289;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D_1 {

    private List<Integer>[] adj;
    private int ansMax = 0;
    private char[] arr;

    private int dp(int cur) {
        int max = 0;
        int secondMax = 0;
        List<Integer> nextList = adj[cur];
        if (nextList == null) {
            ansMax = Math.max(ansMax, 1);
            return 1;
        }
        for (int next : nextList) {
            if (arr[next] == arr[cur]) {
                dp(next);
                continue;
            }

            int t = dp(next);
            if (t > max) {
                secondMax = max;
                max = t;
            } else if (t > secondMax) {
                secondMax = t;
            }
        }

        ansMax = Math.max(ansMax, max + secondMax + 1);
        return max + 1;
    }

    public int longestPath(int[] parents, String s) {
        int len = parents.length;
        if (len == 1) {
            return 1;
        }

        adj = new ArrayList[len];
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -1) {
                continue;
            }

            int u = i;
            int v = parents[i];
            if (adj[v] == null) {
                adj[v] = new ArrayList<>();
            }
            adj[v].add(u);
        }

        arr = s.toCharArray();
        dp(0);
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
