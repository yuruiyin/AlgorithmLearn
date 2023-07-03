package contest.contest340;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B {

    public long[] distance(int[] nums) {
        int len = nums.length;
        long[] ansArr = new long[len];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        Map<Integer, Long> preMap = new HashMap<>();
        Map<Integer, List<Integer>> preListMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            List<Integer> indexList = map.get(nums[i]);
            long cur = 0;
            if (!preMap.containsKey(nums[i])) {
                for (int idx: indexList) {
                    cur += Math.abs(i - idx);
                }
                preMap.put(nums[i], cur);
            } else {
                long pre = preMap.get(nums[i]);
                List<Integer> preList = preListMap.get(nums[i]);
                int preCount = preList.size();
                int preNumIdx = preList.get(preCount - 1);
                cur = pre + (preCount - 1L) * (i - preNumIdx) - (indexList.size() - preCount - 1L) * (i - preNumIdx);
                preMap.put(nums[i], cur);
            }
            if (!preListMap.containsKey(nums[i])) {
                preListMap.put(nums[i], new ArrayList<>());
            }
            preListMap.get(nums[i]).add(i);
            ansArr[i] = cur;
        }
        return ansArr;
    }

}
