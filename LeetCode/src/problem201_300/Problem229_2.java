package problem201_300;

import java.util.*;

public class Problem229_2 {

    // 不按题目要求，开辟一个map来计数
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return new ArrayList<>();
        }

        int needCount = len / 3;
        List<Integer> ansList = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num: countMap.keySet()) {
            if (countMap.get(num) > needCount) {
                ansList.add(num);
            }
        }

        return ansList;
    }

}
