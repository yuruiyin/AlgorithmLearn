package utils;

import java.util.TreeMap;

/**
 * Test11
 *
 * @author: yry
 * @date: 2020/3/15
 */
public class Test11 {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(2, 1);
        treeMap.put(1, 2);
        treeMap.put(3, 4);

        int size = 0;
        for (Integer num : treeMap.keySet()) {
            size += treeMap.get(num);
        }
        System.out.println(size);

        for (Integer num : treeMap.keySet()) {
            int count = treeMap.get(num);
            while ((count--) > 0) {
                // 需要使用循环将num输出count次
                System.out.println(num);
            }
        }

        if (treeMap.containsKey(2)) {
            treeMap.put(2, treeMap.get(2) - 1);
        }

        treeMap.put(4, treeMap.getOrDefault(4, 0) + 2);
    }

}
