package spring_2020_group;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 * dp TLE
 *
 * @author: yry
 * @date: 2020/4/25
 */
public class B {

    private int n;
    private int[] time;
    private int[] preMaxArr;
    private Map<Integer, Long> memoMap;

    private long dp(int idx, int m) {
        if (idx == n) {
            return m == 0 ? 0 : Integer.MAX_VALUE;
        }

        if (m == 0) {
            return Integer.MAX_VALUE;
        }

        if (n - idx <= m) {
            return 0;
        }

        int key = m * n + idx;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int sum = 0;
        int max = 0;
        long ansMin = Integer.MAX_VALUE;
        for (int i = idx; i < n; i++) {
            sum += time[i];
            max = Math.max(max, time[i]);
            ansMin = Math.min(ansMin, Math.max(sum - max, dp(i + 1, m - 1)));
        }

        memoMap.put(key, ansMin);
        return ansMin;
    }

    private void calcPreMaxArr() {
        preMaxArr = new int[n];
        preMaxArr[0] = time[0];
        for (int i = 1; i < n; i++) {
            preMaxArr[i] = Math.max(preMaxArr[i - 1], time[i]);
        }
    }

    public int minTime(int[] time, int m) {
        this.time = time;
        this.n = time.length;
        calcPreMaxArr();

        memoMap = new HashMap<>();
        return (int) dp(0, m);
    }

}
