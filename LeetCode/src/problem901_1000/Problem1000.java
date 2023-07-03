package problem901_1000;

import java.util.*;

public class Problem1000 {

    private int k;

    private Map<String, Integer> memoMap;

    private int sum(List<Integer> list) {
        int ans = 0;
        for (int num : list) {
            ans += num;
        }
        return ans;
    }

    private String listToStr(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int num: list) {
            sb.append(num).append(",");
        }
        return sb.toString();
    }

    private int dp(List<Integer> list) {
        int size = list.size();
        if (k == size) {
            return sum(list);
        }

        String key = listToStr(list);
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int[] preSumArr = new int[size];
        preSumArr[0] = list.get(0);
        for (int i = 1; i < size; i++) {
            preSumArr[i] = preSumArr[i - 1] + list.get(i);
        }

        int ansMin = Integer.MAX_VALUE;
        for (int i = 0; i <= size - k; i++) {
            // [i, i + k - 1]
            int value = preSumArr[i + k - 1] - (i == 0 ? 0 : preSumArr[i - 1]);
            List<Integer> nextList = new ArrayList<>();
            if (i > 0) {
                nextList.addAll(list.subList(0, i));
            }
            nextList.add(value);
            nextList.addAll(list.subList(i + k, size));
            int res = dp(nextList);
            if (res == Integer.MAX_VALUE) {
                continue;
            }
            ansMin = Math.min(ansMin, value + res);
        }

        memoMap.put(key, ansMin);
        return ansMin;
    }

    public int mergeStones(int[] stones, int k) {
        if (stones.length == 1) {
            return 0;
        }
        this.k = k;
        memoMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : stones) {
            list.add(num);
        }
        int ans = dp(list);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
