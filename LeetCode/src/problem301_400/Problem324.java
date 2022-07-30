package problem301_400;

import java.util.Arrays;

public class Problem324 {

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int l = 1;
        int r = len / 2 + 1;
        while (r < len) {
            swap(nums, l, r);
            l += 2;
            r += 2;
        }
    }

}
