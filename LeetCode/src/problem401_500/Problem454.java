package problem401_500;

import java.util.HashMap;
import java.util.Map;

public class Problem454 {

    // TLE
    public int fourSumCount(int[] arrA, int[] arrB, int[] arrC, int[] arrD) {
        Map<Integer, Integer> dCountMap = new HashMap<>();

        for (int num : arrD) {
            dCountMap.put(num, dCountMap.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        for (int numA: arrA) {
            for (int numB: arrB) {
                for (int numC: arrC) {
                    ans += dCountMap.getOrDefault(-numA-numB-numC, 0);
                }
            }
        }

        return ans;
    }

}
