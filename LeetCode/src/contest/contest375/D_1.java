package contest.contest375;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class D_1 {

    private static final int MOD = (int) (1e9 + 7);

    class Node {
        int start;
        int end;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
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

    private int getMaxSubArrCount(int[] nums, Map<Integer, Node> map) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            Node node = map.get(num);
            int end = node.end;
            for (int j = i + 1; j <= end; j++) {
                Node tmpNode = map.get(nums[j]);
                end = Math.max(end, tmpNode.end);
            }

            i = end;
            count++;
        }
        return count;
    }

    public int numberOfGoodPartitions(int[] nums) {
        int len = nums.length;
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            map.putIfAbsent(num, new Node(i, i));
            map.get(num).end = i;
        }

        int maxCount = getMaxSubArrCount(nums, map);
        if (maxCount <= 2) {
            return maxCount;
        }

        return (int) pow(2, maxCount - 1, MOD);
    }

}
