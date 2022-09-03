package contest.contest305;

public class C_1 {

    public boolean validPartition(int[] nums) {
        int len = nums.length;
        if (len == 2) {
            return nums[0] == nums[1];
        }
        boolean[] dp = new boolean[len];
        dp[1] = nums[0] == nums[1];
        dp[2] = nums[1] == nums[0] + 1 && nums[2] == nums[1] + 1 || nums[0] == nums[1] && nums[1] == nums[2];
        for (int i = 3; i < len; i++) {
            dp[i] = dp[i - 2] && nums[i] == nums[i - 1] ||
                    dp[i - 3] && (
                            nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2] ||
                                    nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1
                    );
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
//        System.out.println(new C().validPartition(new int[]{1, 2, 3}));
        // [923198,923198,701131,701132]
//        System.out.println(new C().validPartition(new int[]{923198,923198,701131,701132}));
        System.out.println(new C_1().validPartition(new int[]{923198, 923198}));
    }

}
