package problem201_300;

/**
 * Problem287_3
 *
 * @author: yry
 * @date: 2020/5/26
 */
public class Problem287_3 {

    public int findDuplicate(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int n = nums.length - 1;

        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        return xor;
    }

}
