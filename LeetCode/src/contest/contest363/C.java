package contest.contest363;

import java.util.*;

public class C {

    private boolean isOk(List<Integer> arr, long target, int[] stock, int[] cost, int budget) {
        int n = arr.size();
        long[] countArr = new long[n];
        for (int i = 0; i < n; i++) {
            countArr[i] = arr.get(i) * target;
        }
        long needCost = 0;
        for (int i = 0; i < n; i++) {
            needCost += Math.max(0L, countArr[i] - stock[i]) * cost[i];
            if (needCost > budget) {
                return false;
            }
        }
        return true;
    }

    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int ansMax = 0;
        for (List<Integer> com: composition) {
            int[] stockArr = new int[n];
            int[] costArr = new int[n];
            for (int i = 0; i < n; i++) {
                stockArr[i] = stock.get(i);
            }
            for (int i = 0; i < n; i++) {
                costArr[i] = cost.get(i);
            }

            int l = 0;
            int r = (int) 2e8;
            int count = 0;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                if (isOk(com, mid, stockArr, costArr, budget)) {
                    count = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            ansMax = Math.max(ansMax, count);
        }
        return ansMax;
    }

}
