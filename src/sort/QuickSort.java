package sort;

/**
 * QuickSort
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class QuickSort {

    private static final int M = 15;

    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int left = lo;
        int right = hi;
        while (left < right) {
            while (right > left && nums[right] >= pivot) {
                right--;
            }

            while (left < right && nums[left] <= pivot) {
                left++;
            }

            if (left < right) {
                SortUtils.swap(nums, left, right);
            }
        }

        nums[lo] = nums[left];
        nums[left] = pivot;
        return left;
    }

    private static void qSort(int[] nums, int n, int lo, int hi) {
        if (lo + M >= hi) {
            InsertSort.insertSort(nums, lo, hi);
            return;
        }

        int mid = partition(nums, lo, hi);
        qSort(nums, n, lo, mid - 1);
        qSort(nums, n, mid + 1, hi);
    }

    public static void quickSort(int[] nums) {
        int n = nums.length;
        qSort(nums, n, 0, n - 1);
    }

}
