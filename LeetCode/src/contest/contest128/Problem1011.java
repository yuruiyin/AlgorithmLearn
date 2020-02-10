package contest.contest128;

public class Problem1011 {

    private boolean canComplete(int[] weights, int bound, int d) {
        int len = weights.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (weights[i] > bound) {
                return false;
            }

            sum += weights[i];
            if (sum > bound) {
                sum = weights[i];
                d--;
                if (d == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public int shipWithinDays(int[] weights, int d) {
        int high = 0;
        for (int w : weights) {
            high += w;
        }

        int low = 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            boolean isOk = canComplete(weights, mid, d);
            if (isOk) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1011().shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }

}
