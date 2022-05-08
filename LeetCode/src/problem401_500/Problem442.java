package problem401_500;

import java.util.ArrayList;
import java.util.List;

public class Problem442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ansList = new ArrayList<>();
        int n = nums.length;
        int[] countArr = new int[n + 1];
        for (int num : nums) {
            countArr[num]++;
        }
        for (int i = 1; i <= n; i++) {
            if (countArr[i] == 2) {
                ansList.add(i);
            }
        }
        return ansList;
    }

}
