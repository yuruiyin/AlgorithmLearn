package problem401_500;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem460
 *
 * @author: yry
 * @date: 2020/4/5
 */
public class Problem460 {

    static class LFUCache {

        class Data {
            int freq;
            int id;
            Data(int freq, int id) {
                this.freq = freq;
                this.id = id;
            }
        }

        private int capacity;
        private Map<Integer, Integer> map;
        private Map<Integer, Data> freqMap;
        private int id;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.id = 0;
            map = new HashMap<>();
            freqMap = new HashMap<>();
        }

        public int get(int key) {
            if (!freqMap.containsKey(key)) {
                return -1;
            }

            Data data = freqMap.get(key);
            data.id = ++id;
            data.freq++;
            return map.get(key);
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }

            if (map.keySet().size() == capacity && !map.containsKey(key)) {
                // 先移除最不经常用的
                int minFreq = Integer.MAX_VALUE;
                for (Integer tmpKey : freqMap.keySet()) {
                    int freq = freqMap.get(tmpKey).freq;
                    if (freq < minFreq) {
                        minFreq = freq;
                    }
                }

                int minFreqKey = -1;
                int minId = Integer.MAX_VALUE;
                for (Integer tmpKey : freqMap.keySet()) {
                    Data data = freqMap.get(tmpKey);
                    int id = data.id;
                    int freq = data.freq;
                    if (freq == minFreq && id < minId) {
                        minId = id;
                        minFreqKey = tmpKey;
                    }
                }

                map.remove(minFreqKey);
                freqMap.remove(minFreqKey);
            }

            map.put(key, value);
            if (!freqMap.containsKey(key)) {
                freqMap.put(key, new Data(0, ++id));
            } else {
                freqMap.get(key).freq++;
                freqMap.get(key).id = ++id;
            }
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        cache.get(2);       // 返回 -1 (未找到key 2)
        cache.get(3);       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        cache.get(1);       // 返回 -1 (未找到 key 1)
        cache.get(3);       // 返回 3
        cache.get(4);       // 返回 4
    }

}
