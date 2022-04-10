package contest.contest287;

import java.util.Arrays;

public class C {

    private boolean isOk(int[] candies, long k, int max) {
        int len = candies.length;
        for (int i = len - 1; i >= 0; i--) {
            if (candies[i] < max) {
                return false;
            }

            int count = candies[i] / max;
            k -= count;
            if (k <= 0) {
                return true;
            }
        }
        return false;
    }

    public int maximumCandies(int[] candies, long k) {
        // 二分
        int l = 1;
        int r = (int) 1e7;
        Arrays.sort(candies);
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (isOk(candies, k, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
