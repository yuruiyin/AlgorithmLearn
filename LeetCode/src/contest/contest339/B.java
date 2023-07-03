package contest.contest339;

import java.util.ArrayList;
import java.util.List;

public class B {

    public List<List<Integer>> findMatrix(int[] nums) {
        int[] countArr = new int[201];
        for (int num : nums) {
            countArr[num]++;
        }
        List<List<Integer>> ansList = new ArrayList<>();
        while (true) {
            boolean hasNum = false;
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= 200; i++) {
                if (countArr[i] > 0) {
                    countArr[i]--;
                    list.add(i);
                    hasNum = true;
                }
            }
            if (hasNum) {
                ansList.add(list);
            } else {
                break;
            }
        }
        return ansList;
    }

}
