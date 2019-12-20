package problem201_300;

import java.util.Arrays;

public class Problem280 {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }

}
