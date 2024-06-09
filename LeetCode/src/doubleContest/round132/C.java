package doubleContest.round132;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C {

    private int[][] memo;

    private int len;
    private int[] nums;

    private int[] sufCountArr;

    private int rec(int idx, int k) {
//        System.out.println("k:" + k);
        if (idx == len) {
            return 0;
        }

        if (memo[idx][k] != -1) {
            return memo[idx][k];
        }

        if (k == 0) {
            return sufCountArr[idx];
        }

        int ansMax = 1;
        for (int i = idx + 1; i < len; i++) {
            int tmpRes = nums[i] != nums[idx] ? rec(i, k - 1) + 1 : rec(i, k) + 1;
            ansMax = Math.max(ansMax, tmpRes);
        }

        return memo[idx][k] = ansMax;
    }

    private void calcSufCountArr() {
        sufCountArr = new int[len];
        Map<Integer, Integer> sufCountMap = new HashMap<>();
        for (int i = len - 1; i >= 0; i--) {
            int count = sufCountMap.getOrDefault(nums[i], 0) + 1;
            sufCountMap.put(nums[i], count);
            sufCountArr[i] = count;
        }
    }

    public int maximumLength(int[] nums, int k) {
        len = nums.length;
        this.nums = nums;
        memo = new int[len][k + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        calcSufCountArr();
        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            ansMax = Math.max(ansMax, rec(i, k));
        }
        return ansMax;
    }

}
