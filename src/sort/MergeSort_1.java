package sort;

/**
 * 归并排序 非递归版本
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class MergeSort_1 {

    // 归并排序
    public static void mergeSort(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        for (int sz = 1; sz < n; sz <<= 1) {
            for (int lo = 0; lo < n - sz; lo += (sz << 1)) {
                MergeSort.merge(nums, tmp, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }
    }

}
