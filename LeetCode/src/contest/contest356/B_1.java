package contest.contest356;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class B_1 {

    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int diffCount = set.size();
        int len = nums.length;
        int ans = 0;
        int l = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int e = 0; e < len; e++) {
            countMap.put(nums[e], countMap.getOrDefault(nums[e], 0) + 1);
            if (countMap.size() < diffCount) {
                continue;
            }
            ans += l + 1;
            while (true) {
                int count = countMap.get(nums[l]);
                if (count > 1) {
                    ans++;
                    countMap.put(nums[l], count - 1);
                    l++;
                } else {
                    break;
                }
            }
        }

        return ans;
    }

}
