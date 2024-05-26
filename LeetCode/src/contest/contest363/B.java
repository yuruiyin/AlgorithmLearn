package contest.contest363;

import java.util.*;

public class B {

    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int size = nums.size();
        int ans = 0;
        int first = 0;
        if (nums.get(0) == 0) {
            first = 2;
        }

        ans += first;
        int pre = first;
        for (int i = 1; i < size; i++) {
            if (nums.get(i) >= i + 1) {
                continue;
            }

        }

        return -1;
    }

}
