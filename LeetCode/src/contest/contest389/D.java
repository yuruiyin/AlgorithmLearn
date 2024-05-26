package contest.contest389;

import java.util.ArrayList;
import java.util.List;

public class D {

    public long minimumMoves(int[] nums, int k, int maxChanges) {
        int len = nums.length;
        List<Integer> oneIdxList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                oneIdxList.add(i);
            }
        }

        // todo
        return 0;
    }

}
