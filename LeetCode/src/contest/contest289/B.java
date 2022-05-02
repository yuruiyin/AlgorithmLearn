package contest.contest289;

import java.util.HashMap;
import java.util.Map;

public class B {

    public int minimumRounds(int[] tasks) {
        int len = tasks.length;
        if (len == 1) {
            return -1;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
        }

        int sum = 0;
        for (int key : countMap.keySet()) {
            int count = countMap.get(key);
            boolean isOk = false;
            int minCount = Integer.MAX_VALUE;
            for (int x = 0; 2 * x <= count; x++) {
                int left = count - 2 * x;
                if (left % 3 == 0) {
                    isOk = true;
                    minCount = Math.min(minCount, x + left / 3);
                }
            }
            if (!isOk) {
                return -1;
            }
            sum += minCount;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
