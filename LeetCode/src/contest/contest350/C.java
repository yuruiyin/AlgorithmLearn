package contest.contest350;

import java.util.List;

public class C {

    private static final int MOD = (int) (1e9 + 7);

    private int[] nums;
    private int len;

    private Integer[][] memo;

    private boolean isOk(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            if (list.get(i) % list.get(i + 1) != 0 && list.get(i + 1) % list.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    private int dfs(int flag, int idx) {
        if (flag == ((1 << len) - 1)) {
            return 1;
        }

        if (memo[flag][idx] != null) {
            return memo[flag][idx];
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            if ((flag & (1 << i)) != 0) {
                continue;
            }

            if (nums[idx] % nums[i] != 0 && nums[i] % nums[idx] != 0) {
                continue;
            }

            flag |= (1 << i);
            ans = (ans + dfs(flag, i)) % MOD;
            flag ^= (1 << i);
        }

        return memo[flag][idx] = ans;
    }

    public int specialPerm(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        memo = new Integer[1 << len][len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = (ans + dfs(1 << i, i)) % MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new C().specialPerm(new int[]{2,3,6}));
    }

}
