package doubleContest.round80;

public class D {

    private int findLastSmallerOrEqual(long[] arr, int end, long k) {
        int low = 0;
        int high = end;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = arr[mid];
            if ((arr[end] - midVal) * (end - mid) < k) {
                if (mid == 0 || (arr[end] - arr[mid - 1]) * (end - (mid - 1)) >= k) {
                    if (mid == 0 && arr[end] * (end + 1) < k) {
                        return 0;
                    }
                    return mid + 1;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public long countSubarrays(int[] nums, long k) {
        int len = nums.length;
        long[] preSumArr = new long[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }

        long ans = 0;
        for (int end = 0; end < len; end++) {
            int idx = findLastSmallerOrEqual(preSumArr, end, k);
            if (idx != -1 && idx <= end) {
                ans += (end - idx + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new D().countSubarrays(new int[]{2,1,4,3,5}, 10));
        System.out.println(new D().countSubarrays(new int[]{1,1,1,}, 5));
    }

}
