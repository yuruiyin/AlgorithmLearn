package problem301_400;

public class P330 {

    public int minPatches(int[] nums, int n) {
        int ans = 0;
        int len = nums.length;
        int i = 0;
        long s = 1;
        while (s <= n) {
            if (i < len && nums[i] <= s) {
                s += nums[i++];
            } else {
                s *= 2;
                ans++;
            }
        }
        return ans;
    }

}
