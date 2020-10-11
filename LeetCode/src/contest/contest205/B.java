package contest.contest205;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/6
 */
public class B {

    private int getAns(int[] nums1, int[] nums2) {
        Map<Long, Integer> countMap1 = new HashMap<>();

        for (int num : nums1) {
            long key = (long)num * num;
            countMap1.put(key, countMap1.getOrDefault(key, 0) + 1);
        }

        int len2 = nums2.length;
        int ans = 0;
        for (int i = 0; i < len2; i++) {
            for (int j = i + 1; j < len2; j++) {
                long key = (long)nums2[i] * nums2[j];
                ans += countMap1.getOrDefault(key, 0);
            }
        }

        return ans;
    }

    public int numTriplets(int[] nums1, int[] nums2) {
        return getAns(nums1, nums2) + getAns(nums2, nums1);
    }

}
