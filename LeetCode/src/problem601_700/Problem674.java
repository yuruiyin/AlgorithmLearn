package problem601_700;

public class Problem674 {

    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int maxLen = 1;
        int tmpLen = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                tmpLen++;
            } else {
                if (tmpLen > maxLen) {
                    maxLen = tmpLen;
                }
                tmpLen = 1;
            }
        }

        return Math.max(maxLen, tmpLen);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem674().findLengthOfLCIS(new int[]{1,3,5,4,7}));
        System.out.println(new Problem674().findLengthOfLCIS(new int[]{2,2,2,2,2}));
        System.out.println(new Problem674().findLengthOfLCIS(new int[]{1,3,5,7}));
        System.out.println(new Problem674().findLengthOfLCIS(new int[]{}));
    }
    
}
