package problem401_500;

public class Problem487 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;

        int max = 1;
        int zeroCount = nums[0] == 0 ? 1 : 0;

        while (left <= right && right < n) {
            while (zeroCount <= 1 && right < n - 1) {
                right++;
                if (nums[right] == 0) {
                    zeroCount++;
                }
            }

            if (zeroCount <= 1) {
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
            while (zeroCount > 1 && left < right) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
        }

        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem487().findMaxConsecutiveOnes(new int[]{1,0,1,1,0}));
        System.out.println(new Problem487().findMaxConsecutiveOnes(new int[]{0}));
        System.out.println(new Problem487().findMaxConsecutiveOnes(new int[]{1,0}));

        System.out.println(new Problem487().findMaxConsecutiveOnes(new int[]{1,1,0,1,1,0,0}));
    }
    
}
