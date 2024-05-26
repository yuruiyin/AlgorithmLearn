package doubleContest.round122;

public class B {

    private void swap(int[] arr, int i, int j) {
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

    public boolean canSortArray(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = i; j >= 1; j--) {
                if (nums[j] >= nums[j - 1]) {
                    continue;
                }
                int curBitCount = Integer.bitCount(nums[j]);
                int preBitCount = Integer.bitCount(nums[j - 1]);
                if (curBitCount != preBitCount) {
                    return false;
                }
                swap(nums, j, j - 1);
            }
        }
        return true;
    }

}
