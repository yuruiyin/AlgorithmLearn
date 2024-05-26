package doubleContest.round116;
import java.util.*;

public class C {

    private Integer[][] memo;
    private int[] arr;
    private int len;

    private int rec(int idx, int sum) {
        if (sum == 0) {
            return 0;
        }

        if (sum < 0) {
            return -1;
        }

        if (idx == len) {
            return -1;
        }

        if (memo[idx][sum] != null) {
            return memo[idx][sum];
        }

        int chooseRes = rec(idx + 1, sum - arr[idx]);
        int nonChooseRes = rec(idx + 1, sum);
        int ansMax = -1;
        if (chooseRes != -1) {
            ansMax = Math.max(ansMax, chooseRes + 1);
        }
        if (nonChooseRes != -1) {
            ansMax = Math.max(ansMax, nonChooseRes);
        }

        return memo[idx][sum] = ansMax;
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        len = nums.size();
        arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = nums.get(i);
        }

        memo = new Integer[len][target + 1];
        return rec(0, target);
    }

}
