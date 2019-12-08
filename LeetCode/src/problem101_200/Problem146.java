package problem101_200;

import java.util.*;

public class Problem146 {

    private Map<Integer, Integer> map;
    private int capacity;

    public Problem146(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        int value = map.getOrDefault(key, -1);
        if (value == -1) {
            return -1;
        }
        map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.keySet().size() == capacity && !map.containsKey(key)) {
            Integer oldestKey = map.keySet().iterator().next();
            map.remove(oldestKey);
        }

        if (map.containsKey(key)) {
            map.remove(key);
        }

        map.put(key, value);
    }
    
    public static void main(String[] args) {
        Problem146 lruCache = new Problem146(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));       // 返回  1
        lruCache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(lruCache.get(2));       // 返回 -1 (未找到)
        lruCache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(lruCache.get(1));       // 返回 -1 (未找到)
        System.out.println(lruCache.get(3));       // 返回  3
        System.out.println(lruCache.get(4));       // 返回  4

//        System.out.println(lruCache.get(2));
//        lruCache.put(2, 6);
//        System.out.println(lruCache.get(1));
//        lruCache.put(1, 5);
//        lruCache.put(1, 2);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(2));

//        lruCache.put(2, 1);
//        lruCache.put(1, 1);
//        lruCache.put(2, 3);
//        lruCache.put(4, 1);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(2));
    }
    
}
