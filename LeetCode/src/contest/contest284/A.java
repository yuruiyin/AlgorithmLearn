package contest.contest284;

import java.util.ArrayList;
import java.util.List;

public class A {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int len = nums.length;
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (key == nums[i]) {
                indexList.add(i);
            }
        }

        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int idx : indexList) {
                if (Math.abs(i - idx) <= k) {
                    ansList.add(i);
                    break;
                }
            }
        }
        return ansList;
    }

}
