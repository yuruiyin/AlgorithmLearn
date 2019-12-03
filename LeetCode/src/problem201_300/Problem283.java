package problem201_300;

public class Problem283 {

    public void moveZeroes(int[] nums) {
        int firstZeroIndex = -1;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                firstZeroIndex = i;
                break;
            }
        }

        if (firstZeroIndex == -1) {
            return;
        }

        for (int i = firstZeroIndex + 1; i < len; i++) {
            if (nums[i] != 0) {
                nums[firstZeroIndex] = nums[i];
                nums[i] = 0;
                for (int j = firstZeroIndex + 1; j < len; j++) {
                    if (nums[j] == 0) {
                        firstZeroIndex = j;
                        break;
                    }
                }
            }
        }
    }

}
