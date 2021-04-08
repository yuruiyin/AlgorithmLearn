package doubleContest.round49;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/3
 */
public class C {

    private static final int MOD = (int) (1e9 + 7);

    private int reverse(int num) {
        String str = String.valueOf(num);
        StringBuilder sb = new StringBuilder(str);
        return Integer.parseInt(sb.reverse().toString());
    }

    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        map.put(nums[0] - reverse(nums[0]), 1);
        long ans = 0;
        for (int i = 1; i < len; i++) {
            int value = nums[i] - reverse(nums[i]);
            int count = map.getOrDefault(value, 0);
            ans = (ans + count) % MOD;
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        return (int) ans;
    }

}
