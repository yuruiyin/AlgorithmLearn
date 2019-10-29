package problem001_100;

import utils.PrintUtil;

public class Problem080 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int count = 1;
        int duplicateCount = 0;

        for (int i = 1; i < n - duplicateCount;) {
            if (nums[i] == nums[i-1]) {
                if (count == 2) {
                    int value = nums[i];
                    System.arraycopy(nums, i+1, nums, i, n - i - 1);
                    nums[n-1] = value;
                    duplicateCount++;
                    continue;
                }
                count++;
                i++;
            } else {
                count = 1;
                i++;
            }
        }

        return n - duplicateCount;
    }
    
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,1,2,2,3};
        System.out.println(new Problem080().removeDuplicates(nums1));
        PrintUtil.printIntArray(nums1);

        int[] nums2 = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(new Problem080().removeDuplicates(nums2));
        PrintUtil.printIntArray(nums2);

    }
    
}
