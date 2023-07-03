package contest.contest344;

import java.util.HashMap;
import java.util.Map;

public class B {

    class FrequencyTracker {

        private Map<Integer, Integer> countMap;
        private int[] countArr;

        public FrequencyTracker() {
            countMap = new HashMap<>();
            countArr = new int[200001];
        }

        public void add(int number) {
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
            int curCount = countMap.get(number);
            countArr[curCount]++;
            if (curCount > 1) {
                countArr[curCount - 1]--;
            }
        }

        public void deleteOne(int number) {
            int preCount = countMap.getOrDefault(number, 0);
            if (preCount == 0) {
                return;
            }
            countMap.put(number, preCount - 1);
            countArr[preCount]--;
            countArr[preCount - 1]++;
        }

        public boolean hasFrequency(int frequency) {
            return countArr[frequency] > 0;
        }
    }

}
