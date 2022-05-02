package contest.contest289;

import java.util.HashMap;
import java.util.Map;

public class B_1 {

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
            if (count == 1) {
                return -1;
            } else if (count % 3 == 0) {
                sum += count / 3;
            } else {
                sum += count / 3 + 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
