package problem101_200;

import java.util.LinkedHashMap;
import java.util.Map;

public class Problem146_1 {

    class LRUCache {

        private Map<Integer, Integer> map;

        public LRUCache(int capacity) {
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            map.put(key, value);
        }

    }

}
