package problem601_700;

import java.util.Arrays;

// 回溯+记忆化
public class Problem647 {

    private String s;
    private int len;
    private int[] memo;

    private boolean isPalindrome(int start, int end) {
        if (start == end) {
            return true;
        }

        int mid = (start + end) >>> 1;
        for (int i = start; i <= mid; i++) {
            if (s.charAt(i) != s.charAt(end - (i-start))) {
                return false;
            }
        }
        return true;
    }

    private int backTrack(int start) {
        if (start == len) {
            return 0;
        }

        if (memo[start] != -1) {
            return 0;
        }

        int ans = 0;
        for (int end = start; end < len; end++) {
            ans += isPalindrome(start, end) ? 1 : 0;
            ans += backTrack(end + 1);
        }

        memo[start] = ans;
        return ans;
    }

    public int countSubstrings(String s) {
        this.s = s;
        this.len = s.length();
        if (len >= 1000) {
            return 0;
        }

        memo = new int[len];
        Arrays.fill(memo, -1);
        return backTrack(0);
    }

}
