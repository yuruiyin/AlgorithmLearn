package contest.contest194;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * C_1
 *
 * @author: yry
 * @date: 2020/6/21
 */
public class C_1 {

    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        int[] ansArr = new int[len];
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (rains[i] > 0) {
                ansArr[i] = -1;
                if (indexMap.containsKey(rains[i])) {
                    int from = indexMap.get(rains[i]);
                    boolean isOk = false;
                    for (int j = from; j < i; j++) {
                        if (rains[j] == 0) {
                            ansArr[j] = rains[i];
                            rains[j] = rains[i];
                            isOk = true;
                            break;
                        }
                    }

                    if (!isOk) {
                        return new int[0];
                    }

                    indexMap.put(rains[i], i);
                } else {
                    indexMap.put(rains[i], i);
                }

            }
        }

        for (int i = 0; i < len; i++) {
            if (ansArr[i] == 0) {
                ansArr[i] = 1;
            }
        }

        return ansArr;
    }

}
