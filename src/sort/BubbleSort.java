package sort;

/**
 * BubbleSort
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class BubbleSort {

    // 普通冒泡排序，TLE
    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    SortUtils.swap(nums, j, j + 1);
                }
            }
        }
    }

    // 优化后的冒泡排序，每一轮将当前最大元素沉底的过程中，记录最后一次交换的位置, 还是会TLE
    public static void bubbleSort1(int[] nums) {
        int n = nums.length;
        int end = n - 2;
        while (end >= 0) {
            int lastSwap = -1;
            for (int j = 0; j <= end; j++) {
                if (nums[j] > nums[j + 1]) {
                    SortUtils.swap(nums, j, j + 1);
                    lastSwap = j;
                }
            }
            end = lastSwap;
        }
    }

}
