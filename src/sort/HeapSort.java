package sort;

/**
 * HeapSort
 *
 * @author: yry
 * @date: 2020/3/26
 */
public class HeapSort {

    // 自上而下的堆化, 非递归版本
    private static void heapify(int[] nums, int i, int n) {
        while (true) {
            int maxPos = i;
            if (2 * i + 1 < n && nums[2 * i + 1] > nums[maxPos]) {
                maxPos = 2 * i + 1;
            }

            if (2 * i + 2 < n && nums[2 * i + 2] > nums[maxPos]) {
                maxPos = 2 * i + 2;
            }

            if (maxPos == i) {
                return;
            }

            SortUtils.swap(nums, i, maxPos);
            i = maxPos;
        }
    }

//    // 自上而下的堆化, 递归版本
//    private static void heapify(int[] nums, int i, int n) {
//        int maxPos = i;
//        if (2 * i + 1 < n && nums[2 * i + 1] > nums[maxPos]) {
//            maxPos = 2 * i + 1;
//        }
//
//        if (2 * i + 2 < n && nums[2 * i + 2] > nums[maxPos]) {
//            maxPos = 2 * i + 2;
//        }
//
//        if (maxPos == i) {
//            return;
//        }
//
//        SortUtils.swap(nums, i, maxPos);
//        heapify(nums, maxPos, n);
//    }

    // 建堆
    private static void buildHeap(int[] nums, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(nums, i, n);
        }
    }

    // 若是从小到大排序，那么就是大顶堆，每次将堆顶元素与末尾元素进行对换
    public static void heapSort(int[] nums) {
        int n = nums.length;
        buildHeap(nums, n);
        for (int i = n - 1; i >= 1; i--) {
            SortUtils.swap(nums, 0, i);
            heapify(nums, 0, i);
        }
    }

}
