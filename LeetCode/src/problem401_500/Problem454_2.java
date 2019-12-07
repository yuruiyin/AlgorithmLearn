package problem401_500;

import java.util.HashMap;
import java.util.Map;

public class Problem454_2 {

    public int fourSumCount(int[] arrA, int[] arrB, int[] arrC, int[] arrD) {
        Map<Integer, Integer> abCountMap = new HashMap<>();
        int len = arrA.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = arrA[i] + arrB[j];
                abCountMap.put(sum, abCountMap.getOrDefault(sum, 0) + 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = arrC[i] + arrD[j];
                ans += abCountMap.getOrDefault(-sum, 0);
            }
        }

        return ans;
    }

}
