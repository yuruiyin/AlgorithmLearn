package problem401_500;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Problem435 {

    private int[] memo;
    private int len;
    private int[][] intervals;

    // 左区间 >= 指定值的区间个数
    private Map<Integer, Integer> ceilingCountMap;

    /**
     * 从curIdx让后面区间集合不重叠需要移除的最少的区间个数
     */
    private int dp(int curIdx) {
        if (curIdx >= len - 1) {
            return 0;
        }

        if (memo[curIdx] != -1) {
            return memo[curIdx];
        }

        int[] curInterval = intervals[curIdx];
        int[] nextInterval = intervals[curIdx + 1];
        if (curInterval[1] <= nextInterval[0]) {
            // 当前区间与后面的区间没有重叠
            return dp(curIdx + 1);
        }

        // 当前移除或不移除
        int removeRes = 1 + dp(curIdx + 1);
        int noRemoveRes = 0;
        int nextIdx = len - ceilingCountMap.get(curInterval[1]);
        noRemoveRes += nextIdx - curIdx - 1;
        noRemoveRes += dp(nextIdx);
        int ans = Math.min(noRemoveRes, removeRes);
        memo[curIdx] = ans;
        return ans;
    }

    private void calcCeilingCountArr(int[][] intervals) {
        int len = intervals.length;
        ceilingCountMap = new HashMap<>();
        for (int i = 50000, curIdx = len - 1; i >= -50000 && curIdx >= 0; i--) {
            int count = 0;
            while (curIdx >= 0 && intervals[curIdx][0] >= i) {
                curIdx--;
                count++;
            }
            ceilingCountMap.put(i, count + ceilingCountMap.getOrDefault(i + 1, 0));
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        this.len = intervals.length;
        this.intervals = intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        calcCeilingCountArr(intervals);

        memo = new int[len];
        Arrays.fill(memo, -1);
        return dp(0);
    }

    public static void main(String[] args) {
        System.out.println(new Problem435().eraseOverlapIntervals(new int[][]{
                {1,2},{2,3},{3,4},{1,3}
        }));
    }

}
