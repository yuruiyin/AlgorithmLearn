package contest.contest423;

public class C {

    private static final int MOD = (int) (1e9 + 7);

    public int sumOfGoodSubsequences(int[] nums) {
        int len = nums.length;
        int[] dp = new int[(int) (1e5 + 10)];
        int[] dpCount = new int[(int) (1e5 + 10)];
        dp[nums[0]] = nums[0];
        dpCount[nums[0]] = 1;
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            long newCount = (nums[i] == 0 ? 0 : dpCount[nums[i] - 1]) + dpCount[nums[i] + 1] + 1;
            int tmpCount = (int) (((((nums[i] == 0 ? 0 : dp[nums[i] - 1]) + dp[nums[i] + 1]) % MOD) + newCount * nums[i]) % MOD);
            dpCount[nums[i]] = (int) ((dpCount[nums[i]] + newCount) % MOD);
            ans = (ans + tmpCount) % MOD;
            dp[nums[i]] = (dp[nums[i]] +  tmpCount) % MOD;
        }

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new C().sumOfGoodSubsequences(new int[]{1, 2, 1}));
//        System.out.println(new C().sumOfGoodSubsequences(new int[]{10, 10, 1, 9}));
        // [5,4,3,1,0,0,1]
        System.out.println(new C().sumOfGoodSubsequences(new int[]{5,4,3,1,0,0,1}));
    }

}
