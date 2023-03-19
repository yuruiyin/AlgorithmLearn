package contest.contest336;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C {

    public long beautifulSubarrays(int[] nums) {
        long ans = 0;
        int len = nums.length;
        int[] countArr = new int[32];
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            for (int j = 0; j < 32 && num > 0; j++) {
                int bit = num % 2;
                countArr[j] += bit;
                num >>>= 1;
            }

            int curNum = 0;
            for (int j = 0; j < 32; j++) {
                if (countArr[j] % 2 == 1) {
                    curNum += (1 << j);
                }
            }

            int preCount = countMap.getOrDefault(curNum, 0);
            ans += preCount;
            if (curNum == 0) {
                ans++;
            }
            countMap.put(curNum, preCount + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new C().beautifulSubarrays(new int[]{4,3,1,2,4}));
    }

}
