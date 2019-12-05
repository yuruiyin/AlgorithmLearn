package problem401_500;

import java.util.HashMap;
import java.util.Map;

public class Problem494 {
    private int[] nums;
    private int len;
    private Map<Long, Integer> memo;

    private int dfs(int from, int sum) {
        if (from == len) {
            return sum == 0 ? 1 : 0;
        }

        long key = sum * len + from;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int minusRes = dfs(from+1, sum + nums[from]);
        int plusRes = dfs(from+1, sum - nums[from]);

        memo.put(key, minusRes + plusRes);

        return memo.get(key);
    }

    public int findTargetSumWays(int[] nums, int sum) {
        this.nums = nums;
        this.len = nums.length;
        memo = new HashMap<>();
        return dfs(0, sum);
    }


}
