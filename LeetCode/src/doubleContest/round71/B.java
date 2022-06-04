package doubleContest.round71;

import java.util.ArrayList;
import java.util.List;

public class B {

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        List<Integer> equalList = new ArrayList<>();
        for (int num : nums) {
            if (num < pivot) {
                leftList.add(num);
            } else if (num == pivot) {
                equalList.add(num);
            } else {
                rightList.add(num);
            }
        }
        int len = nums.length;
        int[] ansArr = new int[len];
        int idx = 0;
        for (int num : leftList) {
            ansArr[idx++] = num;
        }
        for (int num : equalList) {
            ansArr[idx++] = num;
        }
        for (int num : rightList) {
            ansArr[idx++] = num;
        }
        return ansArr;
    }

}
