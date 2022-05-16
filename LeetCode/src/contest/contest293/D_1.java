package contest.contest293;

import java.util.*;

public class D_1 {

    class CountIntervals {

        private TreeMap<Integer, Integer> treeMap;
        private int count = 0;

        public CountIntervals() {
            treeMap = new TreeMap<>();
        }

        public void add(int left, int right) {
            while (true) {
                Integer first = treeMap.floorKey(right);
                if (first == null || treeMap.get(first) < left) {
                    break;
                }
                count -= treeMap.get(first) - first + 1;
                right = Math.max(right, treeMap.get(first));
                left = Math.min(left, first);
                treeMap.remove(first);
            }
            treeMap.put(left, right);
            count += (right - left + 1);
        }

        public int count() {
            return count;
        }
    }

}
