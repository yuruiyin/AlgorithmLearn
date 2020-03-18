package lcci;

/**
 * Lcci1011_1
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class Lcci1011_1 {

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void wiggleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if ((i & 1) == 0 && nums[i] < nums[i+1] || (i & 1) == 1 && nums[i] > nums[i+1]) {
                swap(nums, i, i+1);
            }
        }
    }

}
