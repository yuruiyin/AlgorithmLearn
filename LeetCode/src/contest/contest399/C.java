package contest.contest399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C {

    private static List<Integer>[] factors = new ArrayList[1000001];

    private static List<Integer> getAllFactors(int num) {
        if (factors[num] != null) {
            return factors[num];
        }
        List<Integer> list = new ArrayList<>();
        int end = (int) Math.sqrt(num);
        for (int i = 1; i <= end; i++) {
            if (num % i == 0) {
                list.add(i);
                if (num / i != i) {
                    list.add(num / i);
                }
            }
        }
        return factors[num] = list;
    }

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums2) {
            countMap.put(num * k, countMap.getOrDefault(num * k, 0) + 1);
        }

        long ans = 0;
        for (int num: nums1) {
            List<Integer> factors = getAllFactors(num);
            for (int factor: factors) {
                ans += countMap.getOrDefault(factor, 0);
            }
        }

        return ans;
    }

}
