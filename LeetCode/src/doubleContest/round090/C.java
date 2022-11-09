package doubleContest.round090;

import java.util.*;

public class C {

    public int destroyTargets(int[] nums, int space) {
        int len = nums.length;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(nums[0] % space, 1);
        map.put(nums[0] % space, nums[0]);
        int ansMaxCount = 1;
        for (int i = 1; i < len; i++) {
            if (!countMap.containsKey(nums[i] % space)) {
                countMap.put(nums[i] % space, 1);
                map.put(nums[i] % space, nums[i]);
            } else {
                int count = countMap.get(nums[i] % space) + 1;
                countMap.put(nums[i] % space, count);
                ansMaxCount = Math.max(ansMaxCount, count);
            }
        }

        int minNum = Integer.MAX_VALUE;
        for (int num : countMap.keySet()) {
            if (countMap.get(num) == ansMaxCount) {
                minNum = Math.min(minNum, map.get(num));
            }
        }

        return minNum;
    }

    public static void main(String[] args) {
//        [1,5,3,2,2]
//        10000
//        [625879766,235326233,250224393,501422042,683823101,948619719,680305710,733191937,182186779,353350082]
//        4
        System.out.println(new C().destroyTargets(new int[]{1,5,3,2,2}, 10000));
        System.out.println(new C().destroyTargets(new int[]{625879766,235326233,250224393,501422042,683823101,948619719,680305710,733191937,182186779,353350082}, 4));
    }

}
