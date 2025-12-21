package contest.contest463;

import java.util.HashMap;
import java.util.Map;

public class D {

    private static final int MOD = (int) (1e9 + 7);

    // 快速幂
    public static int pow(long x, long n, int mod) {
        long res = 1;
        x %= mod;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x % mod;
            }

            x = x * x % mod;
            n >>>= 1;
        }
        return (int) res % mod;
    }

    // 乘法逆元 (v^(mod-2) % mod)
    static long modInverse(long v) {
        return pow(v, MOD - 2, MOD);
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;

        // 用 Map<(k, offset), 差分数组> 保存查询
        Map<Long, long[]> diffMap = new HashMap<>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            long v = q[3];

            int offset = l % k;
            long key = ((long) k << 20) + offset;

            // 序列 index 范围 [start, end]
            int start = (l - offset) / k;
            int end = (r - offset) / k;

            long[] diff = diffMap.computeIfAbsent(key, kk -> new long[(n / k) + 5]);

            if (diff[start] == 0) {
                diff[start] = 1;
            }
            diff[start] = (diff[start] * v) % MOD;

            if (diff[end + 1] == 0) {
                diff[end + 1] = 1;
            }
            diff[end + 1] = (diff[end + 1] * modInverse(v)) % MOD;
        }

        // 使用差分
        for (Map.Entry<Long, long[]> entry : diffMap.entrySet()) {
            long key = entry.getKey();
            int k = (int) (key >> 20);
            int offset = (int) (key & ((1 << 20) - 1));
            long[] diff = entry.getValue();

            long mul = 1;
            for (int pos = 0; pos < diff.length && offset + pos * k < n; pos++) {
                if (diff[pos] != 0) {
                    mul = (mul * diff[pos]) % MOD;
                }
                nums[offset + pos * k] = (int) (nums[offset + pos * k] * mul % MOD);
            }
        }

        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int[][] queries = {
                {0,2,1,4},  // 从0到4，每隔2乘以3
        };

        int ans = new D().xorAfterQueries(nums, queries);
        System.out.println(ans);
    }

}
