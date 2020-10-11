package contest.contest209;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/4
 */
public class A {

    public int specialArray(int[] nums) {
        int len = nums.length;
        for (int x = 0; x <= len; x++) {
            int count = 0;
            for (int num : nums) {
                if (num >= x) {
                    count++;
                }
            }

            if (count == x) {
                return x;
            }
        }

        return -1;
    }

}
