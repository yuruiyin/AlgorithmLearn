package contest.contest294;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class B {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        List<int[]> countList = new ArrayList<>();
        int len = capacity.length;
        for (int i = 0; i < len; i++) {
            countList.add(new int[]{capacity[i], rocks[i]});
        }

        Collections.sort(countList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int count = 0;
        for (int i = 0; i < len; i++) {
            int[] pair = countList.get(i);
            int cap = pair[0];
            int rock = pair[1];
            additionalRocks -= (cap - rock);
            if (additionalRocks >= 0) {
                count = i + 1;
                continue;
            }
            break;
        }
        return count;
    }

}
