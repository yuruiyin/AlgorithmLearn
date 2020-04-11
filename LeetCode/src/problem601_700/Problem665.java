package problem601_700;

/**
 * Problem665
 *
 * @author: yry
 * @date: 2020/4/9
 */
public class Problem665 {

    private void calcTwoMax(int[] towMax, int num) {
        // towMax[最大，第二大]
        if (num >= towMax[0]) {
            towMax[1] = towMax[0];
            towMax[0] = num;
        } else {
            if (num > towMax[1]) {
                towMax[1] = num;
            }
        }
    }

    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        boolean hasSmallerBefore = false;
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i-1]) {
                if (hasSmallerBefore) {
                    return false;
                }

                if (i > 1) {
                    if (nums[i] < nums[i - 2]) {
                        nums[i] = nums[i - 1];
                    }
                }

                hasSmallerBefore = true;
            }
        }

        return true;
    }

}
