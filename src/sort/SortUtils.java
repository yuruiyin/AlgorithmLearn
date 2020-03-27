package sort;

/**
 * SortUtils
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class SortUtils {

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
