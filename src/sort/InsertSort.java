package sort;

/**
 * InsertSort
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class InsertSort {

    public static void insertSort(int[] nums, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int cur = nums[i];
            int j;
            for (j = i - 1; j >= lo; j--) {
                if (nums[j] > cur) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = cur;
        }
    }

    // 插入排序
    public static void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (nums[j] > cur) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = cur;
        }
    }

}
