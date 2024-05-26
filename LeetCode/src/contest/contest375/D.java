package contest.contest375;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    class Node {
        int start;
        int end;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private long[] dp;

    private long rec(int curIdx, int[] nums, Map<Integer, Node> map) {
        if (curIdx == nums.length) {
            return 0;
        }

        if (dp[curIdx] != -1) {
            return (int) dp[curIdx];
        }

        int num = nums[curIdx];
        Node node = map.get(num);
        int end = node.end;
        for (int i = curIdx + 1; i <= end; i++) {
            Node tmpNode = map.get(nums[i]);
            end = Math.max(end, tmpNode.end);
        }

        long res = 1 + rec(end + 1, nums, map);
        return dp[curIdx] = res;
    }

    // 快速pow 二分
    private long pow(long x, long n, int mod) {
        long res = 1;
        x %= mod;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % mod;
            }

            x = (x * x) % mod;
            n >>= 1;
        }
        return res % mod;
    }

    public int numberOfGoodPartitions(int[] nums) {
//        给你一个下标从 0 开始、由 正整数 组成的数组 nums。
//
//        将数组分割成一个或多个 连续 子数组，如果不存在包含了相同数字的两个子数组，则认为是一种 好分割方案 。
//
//        返回 nums 的 好分割方案 的 数目。
//
//        由于答案可能很大，请返回答案对 109 + 7 取余 的结果。
        int len = nums.length;
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                Node node = map.get(num);
                node.end = i;
            } else {
                map.put(num, new Node(i, i));
            }
        }

        dp = new long[len];
        Arrays.fill(dp, -1);
        int maxCount = (int) (rec(0, nums, map) % MOD);
        if (maxCount <= 2) {
            return maxCount;
        }

        return (int) pow(2, maxCount - 1, MOD);
    }

}
