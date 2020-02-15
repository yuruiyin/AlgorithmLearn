package lcof;

public class Lcof053_2 {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return len;
    }

}
