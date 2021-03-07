package contest.contest227;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/10
 */
public class A {

    public boolean check(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            boolean isOk = true;
            for (int j = (i + 1) % len, n = 1; n < len && j < len; j = (j + 1) % len, n++) {
                if (nums[j] < nums[(j - 1 + len) % len]) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                return true;
            }
        }

        return false;
    }

}
