package contest.contest231;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/7
 */
public class D {

    public int minChanges(int[] nums, int k) {
        int len = nums.length;
        int ans = 0;
        int[] xorArr = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                xorArr[i] ^= nums[j];
            }
        }

        if (xorArr[0] == 0) {
            for (int i = 1; i < len - k + 1; i++) {
                if (xorArr[i] == 0) {
                    continue;
                }

                nums[i + k - 1] = xorArr[i] ^ nums[i + k - 1];
                ans++;
            }

            return ans;
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            int count = 0;
            int oldNum = nums[j];
            nums[j] = xorArr[0] ^ nums[j];
            for (int i = 1; i < len - k + 1; i++) {
                if (Math.abs(i - j) < k) {
                    xorArr[i] = xorArr[i] ^ oldNum ^ nums[j];
                }
            }
            for (int i = 1; i < len - k + 1; i++) {
                if (xorArr[i] == 0) {
                    continue;
                }

                nums[i + k - 1] = xorArr[i] ^ nums[i + k - 1];
                count++;
            }
            min = Math.min(min, count);
            for (int i = 1; i < len - k + 1; i++) {
                if (Math.abs(i - j) < k) {
                    xorArr[i] = xorArr[i] ^ oldNum ^ nums[j];
                }
            }
            nums[j] = xorArr[0] ^ nums[j];
        }

        return min;

    }

}
