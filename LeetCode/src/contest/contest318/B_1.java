package contest.contest318;

import java.util.HashMap;
import java.util.Map;

public class B_1 {

    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        long ansMax = 0;
        long sum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }
        if (countMap.size() == k) {
            ansMax = sum;
        }
        for (int r = k; r < len; r++) {
            int lNum = nums[r - k];
            int rNum = nums[r];
            countMap.put(rNum, countMap.getOrDefault(rNum, 0) + 1);
            countMap.put(lNum, countMap.getOrDefault(lNum, 0) - 1);
            if (countMap.get(lNum) == 0) {
                countMap.remove(lNum);
            }
            sum -= lNum;
            sum += rNum;
            if (countMap.size() == k && sum > ansMax) {
                ansMax = sum;
            }
        }
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println(new B_1().maximumSubarraySum(new int[]{1,1,2}, 2));
    }

}
