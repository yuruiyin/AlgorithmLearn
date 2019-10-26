package contest.contest148;

import java.util.Arrays;

public class Problem1144 {

    public int movesToMakeZigzag(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int len = nums.length;

        int[] tmpNum = Arrays.copyOfRange(nums, 0, len);

        for (int i = 0; i < len - 1; i++) {
            if ((i & 1) == 0 && tmpNum[i] <= tmpNum[i+1]) {
                count1 += (tmpNum[i+1] - tmpNum[i] + 1);
                tmpNum[i+1] = tmpNum[i] - 1;
            }

            if ((i & 1) == 1 && tmpNum[i] >= tmpNum[i+1]) {
                count1 += (tmpNum[i] - tmpNum[i+1] + 1);
                tmpNum[i] = tmpNum[i+1] - 1;
            }

        }

        for (int i = 0; i < len - 1; i++) {
            if ((i & 1) == 0 && nums[i] >= nums[i+1]) {
                count2 += (nums[i] - nums[i+1] + 1);
                nums[i] = nums[i+1] - 1;
            }

            if ((i & 1) == 1 && nums[i] <= nums[i+1]) {
                count2 += (nums[i+1] - nums[i] + 1);
                nums[i+1] = nums[i] - 1;
            }
        }

        return Math.min(count1, count2);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1144().movesToMakeZigzag(new int[]{2,7,10,9,8,9}));
        System.out.println(new Problem1144().movesToMakeZigzag(new int[]{9,6,1,6,2}));
        System.out.println(new Problem1144().movesToMakeZigzag(new int[]{1}));
    }
    
}
