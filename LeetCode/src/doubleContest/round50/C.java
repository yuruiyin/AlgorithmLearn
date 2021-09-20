package doubleContest.round50;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/17
 */
public class C {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int len = nums.length;
        int[] ansArr = new int[len];
        int value = (1 << maximumBit) - 1;
        for (int i = 0; i < len; i++) {
            ansArr[i] = (xor | value) ^ xor;
            xor = xor ^ nums[len - i - 1];
        }

        return ansArr;
    }

}
