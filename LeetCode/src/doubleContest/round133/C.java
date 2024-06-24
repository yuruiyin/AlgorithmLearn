package doubleContest.round133;

public class C {

    public int minOperations(int[] nums) {
        int len = nums.length;
        int ans = 0;
        int flag = 0;
        for (int i = 0; i < len; i++) {
            if ((nums[i] ^ flag) == 0) {
                ans++;
                flag = flag == 0 ? 1 : 0;
            }
        }
        return ans;
    }


}
