package doubleContest.round095;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class B {

    class DataStream {

        private Map<Integer, Integer> countMap;
        private LinkedList<Integer> list;

        private int value;
        private int k;

        public DataStream(int value, int k) {
            countMap = new HashMap<>();
            list = new LinkedList<>();
            this.value = value;
            this.k = k;
        }

        public boolean consec(int num) {
            list.addLast(num);
            int first = -1;
            if (list.size() > k) {
                first = list.removeFirst();
            }

            if (first != -1) {
                countMap.put(first, countMap.getOrDefault(first, 0) - 1);
            }

            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.getOrDefault(value, 0) == k) {
                return true;
            }
            return false;
        }
    }

}
