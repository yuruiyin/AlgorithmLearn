package contest.contest114;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem954 {

    public boolean canReorderDoubled(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            return true;
        }

        Arrays.sort(arr);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int i = len - 1; i >= 0; i--) {
            int num = arr[i];
            if (countMap.get(num) == 0) {
                continue;
            }

            if (num == 0 && countMap.get(num) % 2 == 1) {
                return false;
            }

            if (num < 0) {
                if (countMap.getOrDefault(num * 2 , 0) == 0) {
                    return false;
                }
                countMap.put(num * 2, countMap.get(num * 2) - 1);
            } else {
                if (num % 2 == 1) {
                    return false;
                }

                if (countMap.getOrDefault(num / 2, 0) == 0) {
                    return false;
                }
                countMap.put(num / 2, countMap.get(num / 2) - 1);
            }

            countMap.put(num, countMap.get(num) - 1);
        }

        return true;
    }

}
