package lcci;

import java.util.ArrayList;
import java.util.List;

/**
 * Lcci1010_1
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class Lcci1010_1 {

    class StreamRank {

        private List<Integer> list;

        public StreamRank() {
            list = new ArrayList<>();
        }

        private int findFirstBigger(List<Integer> list, int target) {
            int size = list.size();
            int low = 0;
            int high = size - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = list.get(mid);
                if (midVal > target) {
                    if (mid == 0 || list.get(mid - 1) <= target) {
                        return mid;
                    }
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return list.size();
        }

        public void track(int x) {
            int insertIndex = findFirstBigger(list, x);
            list.add(insertIndex, x);
        }

        public int getRankOfNumber(int x) {
            return findFirstBigger(list, x);
        }
    }

}
