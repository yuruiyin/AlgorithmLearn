package contest.contest223;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/10
 */
public class D {

    private int[] jobs;
    private int len;
    private int k;

    private  boolean isOk(int idx, int[] costArr, int max) {
        if (idx == len) {
            return true;
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < k; i++) {
            int cost = costArr[i];
            if (visited.contains(cost) || cost + jobs[idx] > max) {
                continue;
            }

            visited.add(cost);
            costArr[i] = cost + jobs[idx];
            boolean ans = isOk(idx + 1, costArr, max);
            if (ans) {
                return true;
            }
            costArr[i] = cost;
        }
        return false;
    }

    public int minimumTimeRequired(int[] jobs, int k) {
        this.len = jobs.length;
        this.jobs = jobs;
        this.k = k;
        int max = 0;
        int sum = 0;
        for (int job : jobs) {
            max = Math.max(max, job);
            sum += job;
        }
        if (len <= k) {
            return max;
        }

        int low = max;
        int high = sum;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (isOk(0, new int[k], mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

}
