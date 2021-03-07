package contest.contest229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/21
 */
public class C {

    private int len;
    private int[] arr;
    private int[] multipliers;
    private int[][] memo;

    private int dp(int l, int r) {
        int idx = l + (len - r - 1);
        if (idx >= multipliers.length) {
            return 0;
        }

        if (memo[l][r] != -1) {
            return memo[l][r];
        }

        int chooseLeftRes = multipliers[idx] * arr[l] + dp(l + 1, r);
        int chooseRightRes = multipliers[idx] * arr[r] + dp(l, r - 1);
        memo[l][r] = Math.max(chooseLeftRes, chooseRightRes);
        return memo[l][r];
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        List<Integer> numList = new ArrayList<>();
        if (nums.length > 2 * m) {
            for (int i = 0; i < m; i++) {
                numList.add(nums[i]);
            }

            for (int i = nums.length - m; i < nums.length; i++) {
                numList.add(nums[i]);
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                numList.add(nums[i]);
            }
        }

        arr = new int[numList.size()];
        this.len = arr.length;
        for (int i = 0; i < len; i++) {
            arr[i] = numList.get(i);
        }

        this.multipliers = multipliers;

        memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(0, len - 1);
    }

}
