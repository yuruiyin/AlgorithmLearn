package doubleContest.round086;

import java.util.TreeMap;

public class D {

    private boolean isOk(int[] chargeTimes, int[] runningCosts, long budget, int k, long[] preSumArr) {
        if (k == 0) {
            return true;
        }
        int len = chargeTimes.length;
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            countMap.put(chargeTimes[i], countMap.getOrDefault(chargeTimes[i], 0) + 1);
        }

        for (int end = k - 1; end < len; end++) {
            // max(chargeTimes) + k * sum(runningCosts)
            long right = k * (preSumArr[end] - (end == k - 1 ? 0 : preSumArr[end - k]));
            long max = countMap.lastKey();
            long value = max + right;
            if (value <= budget) {
                return true;
            }
            int leftCount = countMap.get(chargeTimes[end - k + 1]);
            if (leftCount == 1) {
                countMap.remove(chargeTimes[end - k + 1]);
            } else if (leftCount > 1) {
                countMap.put(chargeTimes[end - k + 1], leftCount - 1);
            }
            if (end != len - 1) {
                countMap.put(chargeTimes[end + 1], countMap.getOrDefault(chargeTimes[end + 1], 0) + 1);
            }
        }
        return false;
    }

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int len = chargeTimes.length;
        long[] preSumArr = new long[len];
        preSumArr[0] = runningCosts[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + runningCosts[i];
        }
        int l = 0;
        int r = len;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (isOk(chargeTimes, runningCosts, budget, mid, preSumArr)) {
//                System.out.println(mid);
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // chargeTimes = [3,6,1,3,4], runningCosts = [2,1,3,4,5], budget = 25
        //[11,12,19]
        //[10,8,7]
        //19
//        System.out.println(new D().maximumRobots(new int[]{3,6,1,3,4}, new int[]{2,1,3,4,5}, 25));
        System.out.println(new D().maximumRobots(new int[]{11,12,19}, new int[]{10,8,7}, 19));
    }

}
