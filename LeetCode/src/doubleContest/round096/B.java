package doubleContest.round096;

public class B {

    public long minOperations(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;
        long sum1 = 0;
        long sum2 = 0;

        if (k == 0) {
            for (int i = 0; i < len; i++) {
                if (nums1[i] != nums2[i]) {
                    return -1;
                }
            }
            return 0;
        }

        for (int i = 0; i < len; i++) {
            int diff = nums1[i] - nums2[i];
            if (diff == 0) {
                continue;
            }

            if (Math.abs(diff) % k != 0) {
                return -1;
            }

            if (diff > 0) {
                sum1 += diff;
            } else {
                sum2 += diff;
            }
        }

        if (sum1 != -sum2) {
            return -1;
        }

        if (k == 0) {
            return -1;
        }

        return sum1 / k;
    }

}
