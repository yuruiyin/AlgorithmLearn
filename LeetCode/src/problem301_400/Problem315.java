package problem301_400;

import java.util.ArrayList;
import java.util.List;

public class Problem315 {

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> ansList = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }

            ansList.add(count);
        }

        return ansList;
    }

}
