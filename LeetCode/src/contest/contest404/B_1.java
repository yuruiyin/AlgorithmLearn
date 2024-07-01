package contest.contest404;

public class B_1 {

    public int maximumLength(int[] nums) {
        int len = nums.length;
        int ansMax = 0;
        int k = 2;

        for (int mod = 0; mod < k; mod++) {
            int[] dp = new int[k];
            dp[nums[0] % k] = 1;
            int tmpMax = 0;
            for (int i = 1; i < len; i++) {
                int tmpMod = nums[i] % k;
                int needMod = (mod + k - tmpMod) % k;
                dp[tmpMod] = Math.max(dp[tmpMod], dp[needMod] + 1);
                tmpMax = Math.max(tmpMax, dp[tmpMod]);
            }
            ansMax = Math.max(ansMax, tmpMax);
        }
        return ansMax;
    }

}
