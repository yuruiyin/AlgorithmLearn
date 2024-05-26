package doubleContest.round116;

import java.util.HashSet;
import java.util.Set;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    public int sumCounts(int[] nums) {
        long len = nums.length;
        Set<Integer> gSet = new HashSet<>();
        for (int num : nums) {
            gSet.add(num);
        }
        if (gSet.size() == 1) {
            // 每个数都相同
            long res = len * (len + 1) / 2;
            return (int) (res % MOD);
        }

        if (gSet.size() == len) {
            // 每个数都不相同
            long ans = 0;
            for (int i = 1; i <= len; i++) {
                ans = (ans + (long)i * i * (len - i + 1)) % MOD;
            }
            return (int) ans;
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < len; j++) {
                set.add(nums[j]);
                int size = set.size();
                sum = (sum + size * size) % MOD;
            }
        }
        return sum;
    }

}
