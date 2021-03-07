package contest.contest218;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/6
 */
public class B {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        for (int num : nums) {
            if (countMap.get(num) == 0) {
                continue;
            }
            int left = k - num;
            int count = countMap.getOrDefault(left, 0);
            if (left == num) {
                if (count <= 1) {
                    continue;
                }

                countMap.put(left, count - 2);
                ans++;
            } else {
                if (count == 0) {
                    continue;
                }

                countMap.put(num, countMap.get(num) - 1);
                countMap.put(left, countMap.get(left) - 1);
                ans++;
            }
        }

        return ans;
    }

}
