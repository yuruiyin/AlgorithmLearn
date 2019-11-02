package problem1101_1200;

/**
 * 判断最大个数与k的乘积是否大于数组个数
 */
public class Problem1121_1 {

    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        int len = nums.length;
        int[] countArr = new int[nums[len - 1] + 1];
        int maxCount = 0;

        for (int num: nums) {
            countArr[num]++;
            if (countArr[num] > maxCount) {
                maxCount = countArr[num];
            }
        }

        return (long) maxCount * k <= len;
    }

    public static void main(String[] args) {

    }

}
