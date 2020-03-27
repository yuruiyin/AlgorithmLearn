package sort;

/**
 * ShellSort
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class ShellSort {

    // 希尔排序：更快速的插入排序, 非常快 9ms
    public static void shellSort(int[] nums) {
        int n = nums.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int x = nums[i];
                int j;
                for (j = i - h; j >= 0 && nums[j] > x; j -= h) {
                    nums[j + h] = nums[j];
                }
                nums[j + h] = x;
            }
            h /= 3;
        }
    }


}
