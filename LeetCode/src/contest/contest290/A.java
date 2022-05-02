package contest.contest290;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A {

    public List<Integer> intersection(int[][] nums) {
        int[] countArr = new int[1001];
        for (int[] arr : nums) {
            for (int num : arr) {
                countArr[num]++;
            }
        }

        List<Integer> ansList = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (countArr[i] == nums.length) {
                ansList.add(i);
            }
        }

        Collections.sort(ansList);
        return ansList;
    }

}
