package problem501_600;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem532
 *
 * @author: yry
 * @date: 2020/4/8
 */
public class Problem532 {

    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        if (k == 0) {
            Set<Integer> visited = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)) {
                    if (!visited.contains(num)) {
                        ans++;
                    }
                    visited.add(num);
                    continue;
                }

                set.add(num);
            }
            return ans;
        }

        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            }

            int another = num - k;
            if (set.contains(another)) {
                ans++;
            }

            int another1 = num + k;
            if (set.contains(another1)) {
                ans++;
            }

            set.add(num);
        }

        return ans;
    }

}
