package doubleContest.round46;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/20
 */
public class B {


    public boolean canChoose(int[][] groups, int[] nums) {
        int from = 0;
        for (int[] group : groups) {
            boolean isFound = false;
            for (int i = from; i < nums.length; i++) {
                int l = i;
                int r = i + group.length;
                if (r <= nums.length && Arrays.equals(group, 0, group.length, nums, l, r)) {
                    isFound = true;
                    from = i + group.length;
                    break;
                }
            }
            if (!isFound) {
                return false;
            }
        }

        return true;
    }

}
