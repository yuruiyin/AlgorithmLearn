package contest.contest093;

import java.util.HashMap;
import java.util.Map;

// TODO TLE, 待优化
public class Problem871_1 {

    private int target;
    private int[][] stations;
    private Map<Long, Long> memoMap;

    private long dfs(long curFuel, int curPos, int from) {
        if (curFuel >= target - curPos) {
            return 0;
        }

        if (from == stations.length) {
            return -1;
        }

        Long key = curFuel * 500 + from;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        long min = Long.MAX_VALUE;
        for (int i = from; i < stations.length; i++) {
            int dis = stations[i][0] - curPos;
            if (dis < 0) {
                continue;
            }

            if (curFuel < dis) {
                break;
            }

            long tmpCount = dfs(curFuel - dis + stations[i][1], stations[i][0], i + 1);
            if (tmpCount == 0) {
                return 1;
            }

            if (tmpCount != -1 && tmpCount < min) {
                min = tmpCount;
            }
        }

        long ans = min == Long.MAX_VALUE ? -1 : min + 1;
        memoMap.put(key, ans);
        return ans;
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // 贪心
        if (startFuel >= target) {
            return 0;
        }

        this.stations = stations;
        this.target = target;

        memoMap = new HashMap<>();
        return (int) dfs(startFuel, 0, 0);
    }

    public static void main(String[] args) {
//        System.out.println(new Problem04().minRefuelStops(100, 10, new int[][]{
//                {10, 60},
//                {20, 30},
//                {30, 30},
//                {60, 40}
//        }));

//        System.out.println(new Problem04().minRefuelStops(100, 50, new int[][]{
//                {25,25},
//                {50,50}
//        }));

        System.out.println(new Problem871_1().minRefuelStops(100, 25, new int[][]{
                {25,25},
                {50,25},
                {75, 25}
        }));
    }

}
