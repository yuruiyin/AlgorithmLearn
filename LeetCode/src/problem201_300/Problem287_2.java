package problem201_300;

public class Problem287_2 {

    public int findDuplicate(int[] nums) {
        // 二分
        int len = nums.length;
        int low = 1;
        int high = len - 1;

        while (low < high) {
            int mid = (low + high) >>> 1;
            int smallerNumCount = 0;
            for (int num: nums) {
                if (num <= mid) {
                    smallerNumCount++;
                }
            }

            if (smallerNumCount > mid) {
                // 重复数字在左侧
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

}
