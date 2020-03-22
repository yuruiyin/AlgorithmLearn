/**
 * LintCode633_1
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode633_1 {

    public int findDuplicate(int[] nums) {
        // write your code here
        int len = nums.length;
        int low = 1;
        int high = len - 1;

        while (low < high) {
            int mid = (low + high) >>> 1;
            int smallerCount = 0;
            for (int num : nums) {
                if (num <= mid) {
                    smallerCount++;
                }
            }

            if (smallerCount > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

}
