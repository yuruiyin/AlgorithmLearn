package contest.contest328;

import java.util.HashMap;
import java.util.Map;

public class C_1 {

    public long countGood(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        long[] dp = new long[len];
        int l = 0;
        Map<Integer, Long> countMap = new HashMap<>();
        long cur = 0;
        countMap.put(nums[0], 1L);
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1];
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0L) + 1);
            long diff = countMap.get(nums[i]) - 1;
            cur += diff;
            if (dp[i] == 0 && cur >= k) {
                dp[i]++;
            }
            int nextL = l;
            for (int j = l; j < i; j++) {
                long newNum = countMap.get(nums[j]) - 1;
                if (cur - newNum < k) {
                    break;
                }
                countMap.put(nums[j], newNum);
                dp[i]++;
                cur -= newNum;
                nextL = j + 1;
            }
            l = nextL;
        }

        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += dp[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new C_1().countGood(new int[]{3,1,4,3,2,2,4}, 2));
    }

}
