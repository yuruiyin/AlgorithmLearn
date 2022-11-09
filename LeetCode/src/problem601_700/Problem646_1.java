package problem601_700;

import java.util.Arrays;
import java.util.Comparator;

public class Problem646_1 {

    private int findLastSmallerIdx(int[][] pairs, int to, int target) {
        int l = 0;
        int r = to;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (pairs[mid][1] < target) {
                if (mid == to || pairs[mid + 1][1] >= target) {
                    return mid;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int[] preMaxArr = new int[len];
        preMaxArr[0] = 1;
        for (int i = 1; i < len; i++) {
            int l = pairs[i][0];
            // 二分找到[0, i - 1] 之间r < l的最大值
            int lastSmallerIdx = findLastSmallerIdx(pairs, i - 1, l);
            if (lastSmallerIdx != -1) {
                preMaxArr[i] = preMaxArr[lastSmallerIdx] + 1;
            } else {
                preMaxArr[i] = 1;
            }
            if (preMaxArr[i - 1] > preMaxArr[i]) {
                preMaxArr[i] = preMaxArr[i - 1];
            }
        }
        return preMaxArr[len - 1];
    }

}
