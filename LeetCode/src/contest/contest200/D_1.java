package contest.contest200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * D_1
 *
 * @author: yry
 * @date: 2020/8/2
 */
public class D_1 {

    private static final long MOD = (int) (1e9+7);

    public int maxSum(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        long ans = 0;
        long sum1 = 0;
        int preJ = 0;
        for (int i = 0; i < len1; i++) {
            if (set2.contains(nums1[i])) {
                long sum2 = 0;
                int j;
                for (j = preJ; nums2[j] < nums1[i]; j++) {
                    sum2 += nums2[j];
                }

                preJ = j + 1;
                ans += Math.max(sum1, sum2) + nums1[i];
                sum1 = 0;
            } else {
                sum1 += nums1[i];
            }
        }

        long sum2 = 0;
        int j;
        for (j = preJ; j < len2; j++) {
            sum2 += nums2[j];
        }

        ans += Math.max(sum1, sum2);
        return (int) (ans % MOD);
    }

}
