package doubleContest.round142;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B {

    private char[] arr;

    private int n;

    private int[] parent;

    private int[] newParent;

    private Integer[][] dp;

    private int[] ancestorDp;

    private List<Integer>[] adj;

    private Integer[] rec(int idx) {
        if (idx == 0) {
            Integer[] res = new Integer[26];
            Arrays.fill(res, -1);
            res[arr[0] - 'a'] = 0;
            return res;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        Integer[] tmpRes = rec(parent[idx]);
        Integer[] res = Arrays.copyOf(tmpRes, 26);
        for (int i = 0; i < 26; i++) {
            if (i == (arr[idx] - 'a') && res[i] != -1) {
                ancestorDp[idx] = res[i];
                break;
            }
        }

        res[arr[idx] - 'a'] = idx;
        return dp[idx] = res;
    }

    private int rec1(int idx, int[] ans) {
        List<Integer> nextList = adj[idx];
        int count = 1;
        for (int next: nextList) {
            count += rec1(next, ans);
        }

        return ans[idx] = count;
    }

    public int[] findSubtreeSizes(int[] parent, String s) {
        arr = s.toCharArray();
        this.n = arr.length;
        this.parent = parent;

        newParent = Arrays.copyOf(parent, n);

        dp = new Integer[n][26];
        Arrays.fill(dp, null);
        ancestorDp = new int[n];
        Arrays.fill(ancestorDp, -1);
        for (int i = 0; i < n; i++) {
            rec(i);
        }

        for (int i = 1; i < n; i++) {
            if (ancestorDp[i] != -1) {
                newParent[i] = ancestorDp[i];
                System.out.println("i: " + i + ", newParent: " + newParent[i]);
            }
        }

        int[] ans = new int[n];
        ans[0] = n;
        adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int p = newParent[i];
            adj[p].add(i);
        }

        rec1(0, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new B().findSubtreeSizes(new int[]{-1,0,0,1,1,1}, "abaabc"));
    }

}
