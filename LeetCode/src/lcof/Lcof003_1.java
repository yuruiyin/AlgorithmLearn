package lcof;

public class Lcof003_1 {

    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i) {
                int num = nums[i];
                if (nums[num] == num) {
                    return num;
                }

                nums[i] = nums[num];
                nums[num] = num;
            }
        }
        return -1;
    }

}
