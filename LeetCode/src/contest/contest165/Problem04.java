package contest.contest165;

public class Problem04 {

    private int sLen;
    private int[][] memo;
    private int[][] memoOfChangeCount; // 字符串替换成回文串所需要的替换字符数记忆化数组

    // 变成回文串需要替换的字符数
    private int getChangeCount(String str, int start, int end) {
        if (memoOfChangeCount[start][end] != -1) {
            return memoOfChangeCount[start][end];
        }

        int mid = (start + end) >>> 1;
        int ans = 0;
        for (int i = start; i <= mid; i++) {
            if (str.charAt(i) != str.charAt(end - (i - start))) {
                ans++;
            }
        }

        memoOfChangeCount[start][end] = ans;
        return ans;
    }

    private int backTrack(String s, int from, int k) {
        // 剩余的字符数少于剩下的可分割次数, 不合法
        if (sLen - from < k) {
            return -1;
        }

        // 没有可分割的次数了，但是还有字符剩余，不合法
        if (k == 0 && from != sLen) {
            return -1;
        }

        // 剩余的字符数等于剩余的可分割次数，说明剩下的k个字符串都是一个字符，一个字符都是回文串，所以无需替换，返回0即可
        if (sLen - from == k) {
            return 0;
        }

        if (memo[from][k] != -1) {
            return memo[from][k];
        }

        // 从不同的位置分割，计算出所有情况的最小值即可
        int min = Integer.MAX_VALUE;
        for (int end = from; end < sLen; end++) {
            int ans = 0;
            ans += getChangeCount(s, from, end);
            int res = backTrack(s, end+1, k-1);
            if (res == -1) {
                continue;
            }
            ans += res;
            if (ans < min) {
                min = ans;
            }
        }

        min = min == Integer.MAX_VALUE ? 0 : min;
        memo[from][k] = min;
        return min;
    }

    public int palindromePartition(String s, int k) {
        sLen = s.length();
        memo = new int[sLen][k+1];
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < k + 1; j++) {
                memo[i][j] = -1;
            }
        }

        memoOfChangeCount = new int[sLen][sLen];
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < sLen; j++) {
                memoOfChangeCount[i][j] = -1;
            }
        }

        return backTrack(s, 0, k);
    }
    
    public static void main(String[] args) {
        
    }
    
}
