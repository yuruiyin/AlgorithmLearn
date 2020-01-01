package contest.contest091;

import java.util.ArrayList;
import java.util.List;

public class Problem862_2 {

    private long[] preSum;

    private int find(List<Integer> indexList, long target) {
        int size = indexList.size();
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = indexList.get(mid);
            if (preSum[midVal] <= target) {
                if (mid == size - 1 || preSum[indexList.get(mid + 1)] > target) {
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int shortestSubarray(int[] arr, int k) {
        int len = arr.length;
        preSum = new long[len];
        preSum[0] = arr[0];
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i-1] + arr[i];
        }

        int minLen = Integer.MAX_VALUE;
        // 存放的是preSum单调递增的索引列表（索引也是递增，类似1,3,5）
        List<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (preSum[i] >= k) {
                minLen = Math.min(minLen, i + 1);
            }

            int maxIndex = find(indexList, preSum[i] - k);
            if (maxIndex != -1) {
                int diff = i - indexList.get(maxIndex);
                minLen = Math.min(minLen, diff);
            }

            int insertIndex = find(indexList, preSum[i]);
            if (insertIndex == -1) {
                // 说明当前preSum比前面所有的都小，前面的太大就没有价值了
//                indexList.clear();
                indexList.add(0, i);
            } else {
                for (int j = indexList.size() - 1; j > insertIndex; j--) {
                    indexList.remove(j);
                }
                indexList.add(i);
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

}
