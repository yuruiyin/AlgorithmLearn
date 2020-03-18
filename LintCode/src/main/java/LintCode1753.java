import java.util.Arrays;

/**
 * LintCode1753
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode1753 {

    private int findLastSmallerOrEqual(int[] arr, int target) {
        int len = arr.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal <= target) {
                if (mid == len - 1 || arr[mid + 1] > target) {
                    return midVal;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    public long doingHomework(int[] cost, int[] times) {
        int costLen = cost.length;
        int[] preCostSum = new int[costLen];
        preCostSum[0] = cost[0];
        for (int i = 1; i < costLen; i++) {
            preCostSum[i] = preCostSum[i-1] + cost[i];
        }

        long ans = 0;
        for (int time: times) {
            ans += findLastSmallerOrEqual(preCostSum, time);
        }
        return ans;
    }

}
