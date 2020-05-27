package contest.contest187;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/3
 */
public class B {

    public boolean kLengthApart(int[] nums, int k) {
        int len = nums.length;
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                indexList.add(i);
            }
        }

        if (indexList.isEmpty()) {
            return true;
        }

        int preIndex = indexList.get(0);
        for (int i = 1; i < indexList.size(); i++) {
            if (indexList.get(i) - preIndex <= k) {
                return false;
            }

            preIndex = indexList.get(i);
        }

        return true;
    }

}
