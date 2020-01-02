package contest.contest094;

import java.util.Arrays;

public class Problem875 {

    private long calcCost(int[] piles, int k) {
        long sum = 0;
        for (int pile : piles) {
            sum += (pile - 1) / k + 1;
        }
        return sum;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        if (len == 1) {
            return piles[0] / h + 1;
        }

        Arrays.sort(piles);
        int low = 1;
        int high = piles[len - 1];
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midCost = calcCost(piles, mid);
            if (midCost <= h) {
                // 速度可以慢一点
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int min = Math.min(low, high);
        int max = Math.max(low, high);
        if (calcCost(piles, min) <= h) {
            return min;
        }

        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem875().minEatingSpeed(new int[]{
                332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184
        }, 823855818));
    }

}
