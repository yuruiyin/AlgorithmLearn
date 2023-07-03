package contest.contest352;

public class A {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int len = nums.length;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] > threshold || nums[i] % 2 != 0) {
                continue;
            }

            int tmpLen = 1;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > threshold || nums[j] % 2 == nums[j - 1] % 2) {
                    break;
                }
                tmpLen++;
            }
            maxLen = Math.max(maxLen, tmpLen);
        }
        return maxLen;
    }

}
