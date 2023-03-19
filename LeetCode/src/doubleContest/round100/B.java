package doubleContest.round100;

import java.util.Arrays;
import java.util.LinkedList;

public class B {

    public int maximizeGreatness(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0;
        for (int num : nums) {
            if (num > nums[i]) {
                i++;
            }
        }
        return i;
    }

}
