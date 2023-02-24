package contest.contest331;

public class C {

    private boolean isOk(int[] arr, int max, int k) {
        int count = 0;
        int len = arr.length;
        for (int i = 0; i < len;) {
            int leftCount = len - i;
            if ((leftCount + 1) / 2 < k - count) {
                return false;
            }
            if (arr[i] <= max) {
                count++;
                i += 2;
                if (count == k) {
                    break;
                }
            } else {
                i++;
            }
        }
        return count == k;
    }

    public int minCapability(int[] nums, int k) {
        // 二分
        int l = 1;
        int r = (int) 1e9;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (isOk(nums, mid, k)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

}
