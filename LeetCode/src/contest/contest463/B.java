package contest.contest463;

public class B {

    private static final int MOD = (int) (1e9 + 7);

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            long v = q[3];

            for (int i = l ; i <= r; i+=k) {
                nums[i] = (int) ((nums[i] * v) % MOD);
            }
        }

        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

}
