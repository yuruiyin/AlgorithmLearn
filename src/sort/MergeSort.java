package sort;

/**
 * MergeSort 递归版本
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class MergeSort {

    // 归并排序
    public static void mergeSort(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        mSort(nums, tmp, 0, n - 1);
    }

    // 将两个有序数组进行合并成一个有序数组
    public static void merge(int[] nums, int[] tmp, int left, int mid, int right) {
        int i = 0, i1, i2;
        for (i1 = left, i2 = mid + 1; i1 <= mid && i2 <= right;) {
            if (nums[i1] <= nums[i2]) {
                tmp[i++] = nums[i1];
                i1++;
            } else {
                tmp[i++] = nums[i2];
                i2++;
            }
        }

        while (i1 <= mid) {
            tmp[i++] = nums[i1++];
        }

        while (i2 <= right) {
            tmp[i++] = nums[i2++];
        }

        for (i = left; i <= right; i++) {
            nums[i] = tmp[i - left];
        }
    }

    private static void mSort(int[] nums, int[] tmp, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) >>> 1;
        mSort(nums, tmp, left, mid);
        mSort(nums, tmp, mid + 1, right);
        if (nums[mid] <= nums[mid + 1]) {  // 如果前半部分的最大值小于等于后半部分的最小值，就无需执行合并操作
            return;
        }
        merge(nums, tmp, left, mid, right);
    }


}
