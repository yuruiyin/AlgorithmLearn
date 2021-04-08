package contest.contest234;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/28
 */
public class C {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> item : knowledge) {
            map.put(item.get(0), item.get(1));
        }

        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int len = arr.length;
        int leftIdx = -1;
        boolean hasLeft = false;
        for (int i = 0; i < len; i++) {
            if (arr[i] == '(') {
                leftIdx = i;
                hasLeft = true;
            } else if (arr[i] == ')') {
                String key = s.substring(leftIdx + 1, i);
                sb.append(map.getOrDefault(key, "?"));
                hasLeft = false;
            } else {
                if (hasLeft) {
                    continue;
                }

                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }

}
