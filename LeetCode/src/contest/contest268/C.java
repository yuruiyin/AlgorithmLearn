package contest.contest268;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/11/21
 */
public class C {

    class RangeFreqQuery {

        private int len;
        private List<Integer>[] indexListArr;

        public RangeFreqQuery(int[] arr) {
            this.len = arr.length;
            indexListArr = new ArrayList[10001];
            for (int i = 0; i < len; i++) {
                if (indexListArr[arr[i]] ==  null) {
                    indexListArr[arr[i]] = new ArrayList<>();
                }
                indexListArr[arr[i]].add(i);
            }
        }

        private int findFirstBiggerOrEqual(List<Integer> list, int target) {
            int low = 0;
            int high = list.size() - 1;

            while (low <= high) {
                int mid = (low + high) >> 1;
                if (target <= list.get(mid)) {
                    if (mid == 0 || target > list.get(mid - 1)) {
                        return mid;
                    }

                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return -1;
        }

        private int findLastSmallerOrEqual(List<Integer> list, int target) {
            int len = list.size();
            int low = 0;
            int high = len - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = list.get(mid);
                if (midVal <= target) {
                    if (mid == len - 1 || list.get(mid + 1) > target) {
                        return mid;
                    }

                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }

        public int query(int left, int right, int value) {
            List<Integer> indexList = indexListArr[value];
            if (indexList == null) {
                return 0;
            }

            int firstBiggerOrEqual = findFirstBiggerOrEqual(indexList, left);
            int lastSmallerOrEqual = findLastSmallerOrEqual(indexList, right);
            if (firstBiggerOrEqual != -1 && lastSmallerOrEqual != -1) {
                return lastSmallerOrEqual - firstBiggerOrEqual + 1;
            }
            return 0;
        }
    }

}
