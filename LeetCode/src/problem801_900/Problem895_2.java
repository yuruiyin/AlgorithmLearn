package problem801_900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem895_2 {

    class FreqStack {
        private Map<Integer, Integer> countMap;
        private List<Integer>[] countToNumListMap;
        private int maxCount;

        public FreqStack() {
            countMap = new HashMap<>();
            countToNumListMap = new ArrayList[10001];
            for (int i = 0; i < 10001; i++) {
                countToNumListMap[i] = new ArrayList<>();
            }
            maxCount = 0;
        }

        public void push(int x) {
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
            int count = countMap.get(x);
            countToNumListMap[count].add(x);
            maxCount = Math.max(maxCount, count);
        }

        public int pop() {
            List<Integer> maxCountNumList = countToNumListMap[maxCount];
            int value = maxCountNumList.remove(maxCountNumList.size()  - 1);
            if (maxCountNumList.isEmpty()) {
                maxCount--;
            }

            countMap.put(value, countMap.get(value) - 1);
            return value;
        }
    }

}
