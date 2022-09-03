package contest.contest_ubiquant2022;

import java.util.HashMap;
import java.util.Map;

public class A {

    private static final long MOD = (int) (1e9+7);

    private int getRevert(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        return Integer.parseInt(sb.reverse().toString());
    }

    public int numberOfPairs(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int len = nums.length;
        long ans = 0;
        for (int i = 0; i < len; i++) {
            int diff = getRevert(nums[i]) - nums[i];
            ans = (ans + countMap.getOrDefault(diff, 0)) % MOD;
            countMap.put(diff, countMap.getOrDefault(diff, 0) + 1);
        }
        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new A().numberOfPairs(new int[]{17,28,39,71}));
        System.out.println("hello");
    }

}
