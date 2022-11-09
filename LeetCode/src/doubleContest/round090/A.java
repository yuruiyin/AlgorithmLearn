package doubleContest.round090;

import java.util.HashMap;
import java.util.Map;

public class A {

    public String oddString(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        for (String str : words) {
            char[] arr = str.toCharArray();
            int len = arr.length;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < len; i++) {
                sb.append(arr[i] - arr[i - 1]).append(",");
            }
            countMap.put(sb.toString(), countMap.getOrDefault(sb.toString(), 0) + 1);
            map.put(sb.toString(), str);
        }

        for (String str : countMap.keySet()) {
            if (countMap.get(str) == 1) {
                return map.get(str);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
