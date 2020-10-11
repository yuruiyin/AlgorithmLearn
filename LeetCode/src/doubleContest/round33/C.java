package doubleContest.round33;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/22
 */
public class C {

    public int minOperations(int[] nums) {
        int len = nums.length;
        int ans = 0;
        while (true) {
            boolean hasNonZero = false;
            boolean hasGreatOne = false;
            for (int i = 0; i < len; i++) {
                if (nums[i] != 0) {
                    hasNonZero = true;
                }

                if (nums[i] == 0) {
                    continue;
                }

                if (nums[i] == 1) {
                    ans++;
                    nums[i] = 0;
                } else {
                    ans += nums[i] % 2;
                    hasGreatOne = true;
                    nums[i] >>>= 1;
                }
            }

            if (!hasNonZero) {
                break;
            }

            if (hasGreatOne) {
                ans++;
            }
        }

        return ans;
    }

}
