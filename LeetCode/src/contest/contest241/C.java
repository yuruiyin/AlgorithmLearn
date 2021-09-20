package contest.contest241;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/16
 */
public class C {

    class FindSumPairs {

        private static final int N = 100001;

        private int[] nums1;
        private int[] nums2;
        private Map<Integer, Integer> countMap2;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            Arrays.sort(nums1);
            this.nums2 = nums2;
            countMap2 = new HashMap<>();
            for (int num : nums2) {
                countMap2.put(num, countMap2.getOrDefault(num, 0) + 1);
            }
        }

        public void add(int index, int val) {
            countMap2.put(nums2[index], countMap2.getOrDefault(nums2[index], 0) - 1);
            nums2[index] += val;
            countMap2.put(nums2[index], countMap2.getOrDefault(nums2[index], 0) + 1);
        }

        public int count(int tot) {
            int ans = 0;
            for (int num : nums1) {
                if (num >= tot) {
                    break;
                }

                int target = tot - num;
                ans += countMap2.getOrDefault(target, 0);
            }

            return ans;
        }
    }

}
