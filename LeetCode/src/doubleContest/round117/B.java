package doubleContest.round117;

public class B {

    private Long[][] memo;

    private int limit;

    private long dfs(int curIdx, int n) {
        if (curIdx == 2) {
            if (n <= limit) {
                return 1;
            }
            return 0;
        }
        int leftCount = 3 - curIdx;
        if (leftCount * limit < n) {
            return 0;
        }

        if (memo[curIdx][n] != null) {
            return memo[curIdx][n];
        }

        int max = Math.min(limit, n);
        long ans = 0;
        for (int i = max; i >= 0; i--) {
            long tmp = dfs(curIdx + 1, n - i);
            if (tmp == 0) {
                break;
            }
            ans += tmp;
        }

        return memo[curIdx][n] = ans;
    }

    public long distributeCandies(int n, int limit) {
        int each = n / 3;
        int mod = n % 3;
        int max = mod != 0 ? each + 1 : each;
        if (max > limit) {
            return 0;
        }

        int firstMax = Math.min(n, limit);
        long ans = 0;
        for (int first = firstMax; first >= 0; first--) {
            int left = n - first;
            if (left > 2 * limit) {
                break;
            }
            if (left <= limit) {
                ans += (left + 1);
            } else {
                int left1 = left - limit;
                ans += (limit - left1 + 1);
            }
        }

        return ans;
    }

}
