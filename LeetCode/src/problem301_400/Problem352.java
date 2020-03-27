package problem301_400;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem352
 *
 * @author: yry
 * @date: 2020/3/27
 */
public class Problem352 {

    class SummaryRanges {

        private List<int[]> intervalList;

        /** Initialize your data structure here. */
        public SummaryRanges() {
            intervalList = new ArrayList<>();
        }

        private int findLastSmallerOrEqual(int target) {
            int size = intervalList.size();
            int low = 0;
            int high = size - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int[] interval = intervalList.get(mid);
                int right = interval[1];
                if (right <= target) {
                    if (mid == size - 1 || intervalList.get(mid + 1)[1] > target) {
                        return mid;
                    }

                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return -1;
        }

        public void addNum(int val) {
            if (intervalList.isEmpty()) {
                intervalList.add(new int[]{val, val});
                return;
            }

            int index = findLastSmallerOrEqual(val);
            if (index == -1) {
                int[] interval0 = intervalList.get(0);
                if (interval0[0] > val + 1) {
                    intervalList.add(0, new int[]{val, val});
                } else if (interval0[0] == val + 1) {
                    // 合并
                    interval0[0] = val;
                }
                return;
            }

            if (intervalList.get(index)[1] == val) {
                return;
            }

            if (index == intervalList.size() - 1) {
                int[] lastInterval = intervalList.get(intervalList.size() - 1);
                if (lastInterval[1] < val - 1) {
                    intervalList.add(new int[]{val, val});
                } else if (lastInterval[1] == val - 1) {
                    lastInterval[1] = val;
                }
                return;
            }

            if (val == intervalList.get(index)[1] + 1 && val == intervalList.get(index + 1)[0] - 1) {
                // 前后两个要合并
                intervalList.get(index)[1] = intervalList.get(index + 1)[1];
                intervalList.remove(index + 1);
            } else if (val == intervalList.get(index)[1] + 1) {
                intervalList.get(index)[1] = val;
            } else if (val == intervalList.get(index + 1)[0] - 1) {
                intervalList.get(index + 1)[0] = val;
            } else if (val > intervalList.get(index)[1] + 1 && val < intervalList.get(index + 1)[0] - 1) {
                intervalList.add(index + 1, new int[]{val, val});
            }
        }

        public int[][] getIntervals() {
            int size = intervalList.size();
            int[][] ansArr = new int[size][2];
            for (int i = 0; i < size; i++) {
                ansArr[i] = intervalList.get(i);
            }
            return ansArr;
        }
    }

}
