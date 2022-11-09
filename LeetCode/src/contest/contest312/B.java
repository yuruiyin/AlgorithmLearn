package contest.contest312;

public class B {

    public int longestSubarray(int[] nums) {
        int max = 1;
        int len = nums.length;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int ansCount = 0;
        int pre = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == max) {
                pre++;
                ansCount = Math.max(ansCount, pre);
            } else {
                pre = 0;
            }
        }
        return ansCount;
    }

}
