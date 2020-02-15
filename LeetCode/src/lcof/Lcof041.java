package lcof;

import java.util.ArrayList;
import java.util.List;

// 同LC_295
public class Lcof041 {

    class MedianFinder {

        private List<Integer> list;

        /** initialize your data structure here. */
        public MedianFinder() {
            list = new ArrayList<>();
        }

        private int findFirstBigger(List<Integer> list, int target) {
            int low = 0;
            int high = list.size() - 1;

            while (low <= high) {
                int mid = (low + high) >> 1;
                if (target < list.get(mid)) {
                    if (mid == 0 || target >= list.get(mid - 1)) {
                        return mid;
                    }

                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return list.size();
        }

        public void addNum(int num) {
            int firstBiggerIndex = findFirstBigger(list, num);
            list.add(firstBiggerIndex, num);
        }

        public double findMedian() {
            int size = list.size();
            if ((size & 1) == 1) {
                return list.get(size / 2);
            } else {
                return (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
            }
        }
    }

}
