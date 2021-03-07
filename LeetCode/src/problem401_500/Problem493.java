package problem401_500;

/**
 * Problem493
 *
 * @author: yry
 * @date: 2020/11/28
 */
public class Problem493 {

    private int ans = 0;
    private int[] tmpArr;

    private int getReverseCount(int[] nums, int l, int mid, int r) {
        int count = 0;
        for (int i = l, j = mid + 1; i <= mid && j <= r;) {
            if (nums[i] > 2L * nums[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }

        return count;
    }

    private void merge(int[] nums, int l, int mid, int r) {
        // [l, mid] [mid + 1, r]
        ans += getReverseCount(nums, l, mid, r);
        int size = 0;
        int i, j;
        for (i = l, j = mid + 1; i <= mid && j <= r;) {
            if (nums[i] <= nums[j]) {
                tmpArr[size++] = nums[i++];
            } else {
                tmpArr[size++] = nums[j++];
            }
        }

        while (i <= mid) {
            tmpArr[size++] = nums[i++];
        }

        while (j <= r) {
            tmpArr[size++] = nums[j++];
        }

        if (size >= 0) {
            System.arraycopy(tmpArr, 0, nums, l, size);
        }
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = (l + r) >>> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    public int reversePairs(int[] nums) {
        // 归并排序，在将两个有序的数组merge的过程中统计翻转对
        int len = nums.length;
        tmpArr = new int[len];
        mergeSort(nums, 0, len - 1);
        return ans;
    }

}
