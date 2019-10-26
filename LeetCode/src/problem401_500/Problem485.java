package problem401_500;

public class Problem485 {

    public int findMaxConsecutiveOnes1(int[] nums) {
        int max = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                if (count != 0) {
                    if (count > max) {
                        max = count;
                    }
                    count = 0;
                }
            }
        }

        if (count > max) {
            max = count;
        }

        return max;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ans = 0;

        int left = 0;
        int right = 0;

        // 找到第一个1
        while (right < n && nums[right] == 0) {
            right++;
        }

        if (right == n) {
            // 全0
            return 0;
        }

        left = right;

        while (right < n) {
            while (right < n && nums[right] == 1) {
                right++;
            }

            // nums[right] == 0

            int diff = right - left;
            if (diff > ans) {
                ans = diff;
            }

            if (right == n) {
                break;
            }

            while (right < n && nums[right] == 0) {
                right++;
            }

            if (right == n) {
                // 后面全0
                break;
            }
            // nums[right] == 1
            left = right;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem485().findMaxConsecutiveOnes1(new int[]{1,1,0,1,1,1}));
    }
    
}
