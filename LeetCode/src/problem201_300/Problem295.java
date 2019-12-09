package problem201_300;

import java.util.ArrayList;
import java.util.List;

public class Problem295 {

    class MedianFinder {

        private List<Integer> list;

        /** initialize your data structure here. */
        public MedianFinder() {
            list = new ArrayList<>();
        }

        public void addNum(int num) {
            int low = 0;
            int high = list.size() - 1;
            int addedIndex = -1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = list.get(mid);

                if (midVal == num) {
                    addedIndex = mid;
                    break;
                } else if (midVal > num) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (addedIndex == -1) {
                addedIndex = low;
            }

            list.add(addedIndex, num);
        }

        public double findMedian() {
            int size = list.size();

            if ((size & 1) == 1) {
                return list.get(size / 2);
            } else {
                return (list.get(size / 2) + list.get(size / 2 - 1)) / 2.0;
            }
        }
    }

}
