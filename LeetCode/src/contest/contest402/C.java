package contest.contest402;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class C {

    private Map<Integer, Integer> countMap;

    private long[] arr;

    private int len;

    private long[] memo;

    private long rec(int idx) {
        if (idx >= len) {
            return 0;
        }

        if (idx == len - 1) {
            return arr[idx] * countMap.get((int)arr[idx]);
        }

        if (memo[idx] != -1) {
            return memo[idx];
        }

        long chooseRes = arr[idx] * countMap.get((int)arr[idx]);
        for (int i = idx + 1; i < len; i++) {
            if (arr[i] > arr[idx] + 2) {
                chooseRes += rec(i);
                break;
            }
        }

        long nonChooseRes = rec(idx + 1);
        return memo[idx] = Math.max(chooseRes, nonChooseRes);
    }

    public long maximumTotalDamage(int[] power) {
        countMap = new HashMap<>();
        for (int num : power) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> diffSet = countMap.keySet();
        this.len = diffSet.size();
        this.arr = new long[len];
        int i = 0;
        for (int num : diffSet) {
            arr[i++] = num;
        }
        Arrays.sort(arr);
        memo = new long[len];
        Arrays.fill(memo, - 1);
        return rec(0);
    }

    public static void main(String[] args) {
        System.out.println(new C().maximumTotalDamage(new int[]{7,1,6,6}));
    }

}
