package doubleContest.round075;

import java.util.ArrayList;
import java.util.List;

public class B {

    public int triangularSum(int[] nums) {
        int len = nums.length;
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        while (numList.size() > 1) {
            List<Integer> newNumList = new ArrayList<>();
            for (int i = 0; i < numList.size() - 1; i++) {
                newNumList.add((numList.get(i) + numList.get(i + 1)) % 10);
            }
            numList = newNumList;
        }
        return numList.get(0);
    }

}
