package doubleContest.round64;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/30
 */
public class A {

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> countMap = new LinkedHashMap<>();
        for (String word : arr) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        int i = 0;
        for (String key : countMap.keySet()) {
            if (countMap.get(key) == 1) {
                i++;
                if (i == k) {
                    return key;
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
