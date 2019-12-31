package contest.contest087;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem03 {

    public boolean isNStraightHand(int[] hand, int w) {
        int len = hand.length;
        if (len % w != 0) {
            return false;
        }

        Arrays.sort(hand);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : hand) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num: hand) {
            if (countMap.get(num) == 0) {
                continue;
            }

            countMap.put(num, countMap.get(num) - 1);

            for (int i = 1; i < w; i++) {
                if (!countMap.containsKey(num + i) || countMap.get(num + i) == 0) {
                    return false;
                }
                countMap.put(num + i, countMap.get(num + i) - 1);
            }
        }

        return true;
    }

}
