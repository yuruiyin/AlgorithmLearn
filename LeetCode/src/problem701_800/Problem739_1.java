package problem701_800;

import java.util.ArrayList;
import java.util.List;

public class Problem739_1 {

    private int binarySearchFirstBigger(List<Integer> indexList, int target) {
        int low = 0;
        int high = indexList.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = indexList.get(mid);

            if (target < midVal) {
                if (mid == 0 || indexList.get(mid - 1) < target) {
                    return midVal;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    // 二分
    public int[] dailyTemperatures(int[] tArr) {
        int len = tArr.length;
        int[] ansArr = new int[len];
        List<Integer>[] indexListArr = new ArrayList[101];

        for (int i = 0; i < len; i++) {
            int t = tArr[i];
            if (indexListArr[t] == null) {
                indexListArr[t] = new ArrayList<>();
            }
            indexListArr[t].add(i);
        }

        for (int i = 0; i < len; i++) {
            int curT = tArr[i];
            int minIndex = Integer.MAX_VALUE;
            for (int j = curT + 1; j <= 100; j++) {
                if (indexListArr[j] == null) {
                    continue;
                }

                // 二分查找第一个比i大的索引，然后所有[curT+1, 100]中求得的这个索引取最小值即是答案（右侧第一个温度比当天大的元素）
                int nextIndex = binarySearchFirstBigger(indexListArr[j], i);
                if (nextIndex != -1) {
                    if (nextIndex < minIndex) {
                        minIndex = nextIndex;
                    }
                }
            }

            if (minIndex != Integer.MAX_VALUE) {
                ansArr[i] = minIndex - i;
            }
        }

        return ansArr;
    }

}
