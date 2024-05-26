package contest.contest390;


import utils.TreeMultiSet;

import java.util.HashMap;
import java.util.Map;

public class C {

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        TreeMultiSet<Long> set = new TreeMultiSet<>();
        Map<Integer, Long> countMap = new HashMap<>();
        int len = nums.length;
        long[] ans = new long[len];
        for (int i = 0; i < len; i++) {
            long f = freq[i];
            int num = nums[i];
            long oldCount = countMap.getOrDefault(num, 0L);
            long newCount = oldCount + f;
            countMap.put(num, newCount);
            set.remove(oldCount);
            set.add(newCount);
            ans[i] = set.last();
        }
        return ans;
    }

}
