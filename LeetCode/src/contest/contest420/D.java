package contest.contest420;

import java.util.Arrays;
import java.util.TreeSet;

public class D {

    private char[] arr;

    private int n;

    private boolean[] ans;

    private TreeSet<Integer>[] adj;

    private StringBuilder rec(int idx) {
        TreeSet<Integer> nextSet = adj[idx];
        StringBuilder resSb = new StringBuilder();
        for (int next : nextSet) {
            resSb.append(rec(next));
        }

        resSb.append(arr[idx]);
        if (resSb.length() == 1 || isPalindrome(resSb)) {
            ans[idx] = true;
        }

        return resSb;
    }

    private boolean isPalindrome(StringBuilder sb) {
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean[] findAnswer(int[] parent, String s) {
        this.arr = s.toCharArray();
        this.n = parent.length;
        this.adj = new TreeSet[n];
        Arrays.setAll(adj, value -> new TreeSet<>());
        for (int i = 1; i < n; i++) {
            int p = parent[i];
            adj[p].add(i);
        }

        ans = new boolean[n];
        rec(0);
        return ans;
    }

}
