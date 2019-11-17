package problem1001_1100;

import java.util.Arrays;

public class Problem1029_1 {

    /**
     * 贪心
     * 思路：先让2N个人飞往B城市，然后从B城市中选择（costA - costB）最小的N个人飞往A城市即可。
     */
    public int twoCitySchedCost(int[][] costs) {
        int len = costs.length;
        int[] diffArr = new int[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            int[] cost = costs[i];
            count += cost[1];
            diffArr[i] = cost[0] - cost[1];
        }

        Arrays.sort(diffArr);

        for (int i = 0; i < len / 2; i++) {
            count += diffArr[i];
        }

        return count;
    }

}
