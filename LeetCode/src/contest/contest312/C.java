package contest.contest312;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C {

    public List<Integer> goodIndices(int[] nums, int k) {
        int len = nums.length;
        int[] preCountArr = new int[len];
        int[] sufCountArr = new int[len];
        Arrays.fill(preCountArr, 1);
        Arrays.fill(sufCountArr, 1);
        for (int i = 2; i < len - 2; i++) {
            if (nums[i - 1] <= nums[i - 2]) {
                preCountArr[i] = preCountArr[i - 1] + 1;
            } else {
                preCountArr[i] = 1;
            }
        }

        for (int i = len - 3; i >= 2; i--) {
            if (nums[i + 1] <= nums[i + 2]) {
                sufCountArr[i] = sufCountArr[i + 1] + 1;
            } else {
                sufCountArr[i] = 1;
            }
        }

        List<Integer> ansList = new ArrayList<>();
        for (int i = 1; i < len - 1; i++) {
            if (sufCountArr[i] >= k && preCountArr[i] >= k) {
                ansList.add(i);
            }
        }
        return ansList;
    }

}
