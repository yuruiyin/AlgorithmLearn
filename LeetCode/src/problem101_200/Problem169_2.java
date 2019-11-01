package problem101_200;

public class Problem169_2 {

    // 摩尔投票法
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
                if (count > n / 2) {
                    return candidate;
                }
            } else {
                count--;
            }
        }

        return candidate;
    }

}
