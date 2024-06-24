package doubleContest.round133;

public class B {

    public int minOperations(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] == 0) {
                ans++;
                nums[i] = 1;
                nums[i + 1] = nums[i + 1] == 0 ? 1 : 0;
                nums[i + 2] = nums[i + 2] == 0 ? 1 : 0;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                return -1;
            }
        }

        return ans;
    }


}
