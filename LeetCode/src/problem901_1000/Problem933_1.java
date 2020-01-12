package problem901_1000;

import java.util.ArrayList;
import java.util.List;

public class Problem933_1 {

    class RecentCounter {

        private List<Integer> list;

        public RecentCounter() {
            list = new ArrayList<>();
        }

        private int find(int target) {
            int size = list.size();
            int low = 0;
            int high = size - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = list.get(mid);
                if (midVal >= target) {
                    if (mid == 0 || list.get(mid - 1) < target) {
                        return mid;
                    }

                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return -1;
        }

        public int ping(int t) {
            list.add(t);
            if (t <= 3000) {
                return list.size();
            }

            int index = find(t - 3000);
            return list.size() - index;
        }
    }

}
