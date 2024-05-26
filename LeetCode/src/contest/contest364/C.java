package contest.contest364;

import java.util.*;

public class C {

    private long getAns(List<Integer> maxHeights, int maxIdx) {
        int len = maxHeights.size();
        int right = maxHeights.get(maxIdx);
        long res = right;
        for (int j = maxIdx - 1; j >= 0; j--) {
            int cur = Math.min(right, maxHeights.get(j));
            right = cur;
            res += cur;
        }
        int left = maxHeights.get(maxIdx);
        for (int j = maxIdx + 1; j < len; j++) {
            int cur = Math.min(left, maxHeights.get(j));
            left = cur;
            res += cur;
        }
        return res;
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int len = maxHeights.size();
        int maxNum = 0;
        int leftMaxIdx = -1;
        for (int i = 0; i < len; i++) {
            int value = maxHeights.get(i);
            if (value > maxNum) {
                maxNum = value;
                leftMaxIdx = i;
            }
        }

        int rightMaxIdx = -1;
        for (int i = 0; i < len; i++) {
            int value = maxHeights.get(i);
            if (value >= maxNum) {
                maxNum = value;
                rightMaxIdx = i;
            }
        }

        return Math.max(getAns(maxHeights, leftMaxIdx), getAns(maxHeights, rightMaxIdx));
    }

}
