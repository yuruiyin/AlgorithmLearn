package contest.contest316;

import java.util.Arrays;
import java.util.Comparator;

public class C {

    class Data {
        int num;
        long cost;
        Data(int num, long cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    public long minCost(int[] nums, int[] cost) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(nums[i], cost[i]);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.num - o2.num;
            }
        });

        long preCost = 0;
        for (int i = 1; i < len; i++) {
            preCost += datas[i].cost * (datas[i].num - datas[0].num);
        }

        long[] sufCostSumArr = new long[len];
        sufCostSumArr[len - 1] = datas[len - 1].cost;
        for (int i = len - 2; i >= 0; i--) {
            sufCostSumArr[i] = sufCostSumArr[i + 1] + datas[i].cost;
        }

        long ansMin = preCost;
        for (int i = 1; i < len; i++) {
            int diff = datas[i].num - datas[i - 1].num;
            long preCostSum = i == 1 ? 0 : (sufCostSumArr[0] - sufCostSumArr[i - 1]);
            long tmpCost = preCost - diff * datas[i].cost - diff * (i < len - 1 ? sufCostSumArr[i + 1] : 0) +
                    diff * datas[i - 1].cost + preCostSum * diff;
            preCost = tmpCost;
            ansMin = Math.min(ansMin, tmpCost);
        }
        return ansMin;
    }

}
