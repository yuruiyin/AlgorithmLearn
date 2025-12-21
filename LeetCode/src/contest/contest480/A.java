package contest.contest480;

import java.util.Arrays;
import java.util.Map;

public class A {

    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int kMaxSum = 0;
        int len = nums.length;
        for (int i = len - 1; i >= len - k; i--) {
            kMaxSum += nums[i];
        }

        int kMinSum = 0;
        for (int i = 0; i < k; i++) {
            kMinSum += nums[i];
        }

        return Math.abs(kMinSum - kMaxSum);
    }

    public static void main(String[] args) {


    }

}
