package doubleContest.round083;

public class B {

    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long count0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else {
                ans += count0 * (count0 + 1) / 2;
                count0 = 0;
            }
        }

        ans += count0 * (count0 + 1) / 2;
        return ans;
    }

}
