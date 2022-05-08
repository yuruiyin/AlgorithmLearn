package problem401_500;

import java.util.ArrayList;
import java.util.List;

public class Problem442_1 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ansList = new ArrayList<>();
        for (int num : nums) {
            int curNum = Math.abs(num);
            if (nums[curNum - 1] < 0) {
                ansList.add(num);
            } else {
                nums[curNum - 1] *= -1;
            }
        }
        return ansList;
    }

}
