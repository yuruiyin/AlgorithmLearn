package contest.contest130;

import java.util.ArrayList;
import java.util.List;

public class Problem1018_1 {

    public List<Boolean> prefixesDivBy5(int[] arr) {
        int value = 0;
        List<Boolean> ansList = new ArrayList<>();
        for (int num: arr) {
            value <<= 1;
            value = (value + num) % 5;
            ansList.add(value == 0);
        }

        return ansList;
    }

}
