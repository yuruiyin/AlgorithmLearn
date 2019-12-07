package problem401_500;

import java.util.HashMap;
import java.util.Map;

public class Problem454_1 {

    public int fourSumCount(int[] arrA, int[] arrB, int[] arrC, int[] arrD) {
        Map<Integer, Integer> abCountMap = new HashMap<>();

        for (int numA: arrA) {
            for (int numB: arrB) {
                int sum = numA + numB;
                abCountMap.put(sum, abCountMap.getOrDefault(sum, 0) + 1);
            }
        }

        int ans = 0;
        for (int numC: arrC) {
            for (int numD: arrD) {
                int sum = numC + numD;
                ans += abCountMap.getOrDefault(-sum, 0);
            }
        }

        return ans;
    }

}
