package problem201_300;

public class Problem209 {

    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;

        if (n == 0) {
            return 0;
        }

        int minLen = Integer.MAX_VALUE;
        int sum = nums[left];
        while (left <= right && right < n) {
            if (sum >= s) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                }

                if (minLen == 1) {
                    break;
                }

                sum -= nums[left];
                left++;
            } else {
                right++;
                if (right < n) {
                    sum += nums[right];
                }
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }

        return minLen;
    }

    public static void main(String[] args) {
        System.out.println(new Problem209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

}
