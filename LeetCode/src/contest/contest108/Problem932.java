package contest.contest108;

import java.util.HashMap;
import java.util.Map;

public class Problem932 {

    private Map<Integer, int[]> memoMap;

    private int[] f(int n) {
        if (memoMap.containsKey(n)) {
            return memoMap.get(n);
        }

        int[] ans = new int[n];
        if (n == 1) {
            ans[0] = 1;
        } else {
            int index = 0;
            // 奇数, 如果某个数组是漂亮数组，那么每个元素乘以2-1构成的数组也是漂亮数组
            for (int x : f((n + 1) / 2)) {
                ans[index++] = 2 * x - 1;
            }

            // 偶数，如果某个数组是漂亮数组，那么每个元素乘以2构成的数组也是漂亮数组
            for (int x : f(n / 2)) {
                ans[index++] = 2 * x;
            }
        }

        memoMap.put(n, ans);
        return ans;
    }

    public int[] beautifulArray(int n) {
        memoMap = new HashMap<>();
        return f(n);
    }

}
