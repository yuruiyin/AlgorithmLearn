package contest.contest364;

import java.util.*;

public class B {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int len = maxHeights.size();
        long ansMax = 0;
        for (int i = 0; i < len; i++) {
            int right = maxHeights.get(i);
            long res = right;
            for (int j = i - 1; j >= 0; j--) {
                int cur = Math.min(right, maxHeights.get(j));
                right = cur;
                res += cur;
            }
            int left = maxHeights.get(i);
            for (int j = i + 1; j < len; j++) {
                int cur = Math.min(left, maxHeights.get(j));
                left = cur;
                res += cur;
            }
            ansMax = Math.max(ansMax, res);
        }
        return ansMax;
    }

}
