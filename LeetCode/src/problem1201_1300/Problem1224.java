package problem1201_1300;

import java.util.*;

public class Problem1224 {

    public int maxEqualFreq(int[] nums) {
        int ansMax = 2;
        int len = nums.length;
        int[] countArr = new int[100001];
        Map<Integer, Integer> countMap = new HashMap<>();
        countArr[nums[0]]++;
        countArr[nums[1]]++;
        if (nums[0] == nums[1]) {
            countMap.put(2, 1);
        } else {
            countMap.put(1, 2);
        }
        for (int i = 2; i < len; i++) {
            countArr[nums[i]]++;
            int count = countArr[nums[i]];
            if (count == 1) {
                countMap.put(1, countMap.getOrDefault(1, 0) + 1);
            } else {
                countMap.put(count - 1, countMap.get(count - 1) - 1);
                if (countMap.get(count - 1) == 0) {
                    countMap.remove(count - 1);
                }
                countMap.put(count, countMap.getOrDefault(count, 0) + 1);
            }

            int diffCount = countMap.size();
            if (diffCount == 1) {
                if (count == 1 || countMap.get(count) == 1) {
                    ansMax = i + 1;
                }
            } else if (diffCount == 2) {
                Iterator<Integer> iterator = countMap.keySet().iterator();
                int count1 = iterator.next();
                int count2 = iterator.next();
                if (count1 == 1 && countMap.get(count1) == 1 || count2 == 1 && countMap.get(count2) == 1) {
                    ansMax = i + 1;
                } else if (count1 - count2 == 1 && countMap.get(count1) == 1) {
                    ansMax = i + 1;
                } else if (count2 - count1 == 1 && countMap.get(count2) == 1) {
                    ansMax = i + 1;
                }
            }
        }

        return ansMax;
    }

    public static void main(String[] args) {
        // [10,2,8,9,3,8,1,5,2,3,7,6]
//        System.out.println(new Problem1224().maxEqualFreq(new int[]{1,1,1,2,2,2,3,3}));
        System.out.println(new Problem1224().maxEqualFreq(new int[]{10,2,8,9,3,8,1,5,2,3,7,6}));
    }

}
