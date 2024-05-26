package contest.contest357;

import java.util.*;

public class B {

    public boolean canSplitArray(List<Integer> nums, int m) {
        int len = nums.size();
        if (len <= 2) {
            return true;
        }

        for (int i = 0; i < len - 1; i++) {
            if (nums.get(i) + nums.get(i + 1) >= m) {
                return true;
            }
        }

        return false;

    }

}
