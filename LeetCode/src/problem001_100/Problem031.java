package problem001_100;

import java.util.Arrays;

public class Problem031 {

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public void nextPermutation(int[] nums) {
        // 从右往左找到第一个降序的，比如2,3。然后从3开始往后寻找比2大的一个最小的数，与2交换即可, 然后后面从小到大排序即可。
        int len = nums.length;
        if (len == 0 || len == 1) {
            return;
        }

        boolean isFound = false;
        for (int i = len - 1; i >= 1; i--) {
            if (nums[i] > nums[i-1]) {
                int min = Integer.MAX_VALUE;
                int minIndex = -1;
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i-1] && nums[j] < min) {
                        min = nums[j];
                        minIndex = j;
                    }
                }

                swap(nums, i-1, minIndex);
                Arrays.sort(nums, i, len);
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            // 当前序列是最大的，则返回最小的序列
            Arrays.sort(nums);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,2};
        new Problem031().nextPermutation(nums);
        
        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println();

        int[] nums1 = new int[] {1,2,3};
        new Problem031().nextPermutation(nums1);

        for (int num : nums1) {
            System.out.print(num + ",");
        }
        System.out.println();

        int[] nums2 = new int[] {3,2,1};
        new Problem031().nextPermutation(nums2);

        for (int num : nums2) {
            System.out.print(num + ",");
        }
        System.out.println();

        int[] nums3 = new int[] {1,1,5};
        new Problem031().nextPermutation(nums3);

        for (int num : nums3) {
            System.out.print(num + ",");
        }
        System.out.println();
    }

}
