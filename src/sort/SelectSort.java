package sort;

/**
 * SelectSort
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class SelectSort {

    // 选择排序：每次选择最小的元素与当前元素进行交换
    public static void selectSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            SortUtils.swap(nums, i, minIdx);
        }
    }

}
