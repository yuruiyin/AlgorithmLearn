package contest.contest410;

import contest.contest336.D;
import utils.TreeMultiSet;

public class C {

    private static final int MOD = (int) (1e9 + 7);

    private Integer[][] dp;

    private int[] nums;
    private int len;

    private int rec(int preFirst, int idx, TreeMultiSet<Integer> rightSet) {
        if (idx == len) {
            return 1;
        }

        if (preFirst > nums[idx]) {
            return -1;
        }

        if (dp[preFirst][idx] != null) {
            return dp[preFirst][idx];
        }

        int preSecond = nums[idx - 1] - preFirst;

        int ans = 0;
        int rightMin = rightSet.first();
        for (int first = Math.max(preFirst, nums[idx] - preSecond); first <= rightMin; first++) {
            rightSet.remove(nums[idx]);
            int res = rec(first, idx + 1, rightSet);
            rightSet.add(nums[idx]);
            if (res == -1) {
                break;
            }
            ans = (ans + res) % MOD;
        }

        return dp[preFirst][idx] = ans;
    }

    public int countOfPairs(int[] nums) {
        this.nums = nums;
        this.len = nums.length;

        dp = new Integer[1001][2000];

        int rightMin = Integer.MAX_VALUE;
        for (int num : nums) {
            rightMin = Math.min(rightMin, num);
        }

        int ans = 0;
        for (int first = 0; first <= rightMin; first++) {
            TreeMultiSet<Integer> rightSet = new TreeMultiSet<>();
            for (int num : nums) {
                rightSet.add(num);
            }

            rightSet.remove(nums[0]);
            int res = rec(first, 1, rightSet);
            rightSet.add(nums[0]);
            if (res == -1) {
                continue;
            }
            ans = (ans + res) % MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
//        [16,5]
        System.out.println(new C().countOfPairs(new int[]{16,5}));
    }

}
