package problem1001_1100;

public class Problem1004 {

    private int getAns(int[] nums) {
        int n = nums.length;
        int count = 0;
        int max = 0;
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

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;

        int max = 1;
        int zeroCount = nums[0] == 0 ? 1 : 0;

        if (k == 0) {
            // 直接计算连续1的最大值即可
            return getAns(nums);
        }

        while (left <= right && right < n) {
            while (zeroCount <= k && right < n - 1) {
                right++;
                if (nums[right] == 0) {
                    zeroCount++;
                }
            }

            if (zeroCount <= k) {
                int diff = right - left + 1;
                if (diff > max) {
                    max = diff;
                }
            } else {
                int diff = right - left;
                if (diff > max) {
                    max = diff;
                }
            }

            if(right == n - 1) {
                break;
            }

            // right移到了0的位置
            while (zeroCount > k && left < right) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
        }

        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1004().longestOnes(new int[]{0,0,0,0}, 6));  // 4
        System.out.println(new Problem1004().longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2)); // 6
        System.out.println(new Problem1004().longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3)); // 10
        System.out.println(new Problem1004().longestOnes(new int[]{0,0,0,1}, 4)); // 4
        System.out.println(new Problem1004().longestOnes(new int[]{0,0,1,1,1,0,0}, 1)); // 4
        System.out.println(new Problem1004().longestOnes(new int[]{0,0,1,1,1,0,0}, 0)); // 3
    }
    
}
