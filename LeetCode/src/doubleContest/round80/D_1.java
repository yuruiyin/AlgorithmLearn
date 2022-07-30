package doubleContest.round80;

public class D_1 {

    public long countSubarrays(int[] nums, long k) {
        int len = nums.length;
        long[] preSumArr = new long[len + 1];
        preSumArr[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i - 1];
        }

        long ans = 0;
        int newL = 0;
        for (int r = 0; r < len; r++) {
            for (int l = newL; l <= r; l++) {
                long value = (preSumArr[r + 1] - preSumArr[l]) * (r - l + 1);
                if (value < k) {
                    ans += (r - l + 1);
                    newL = l;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().countSubarrays(new int[]{2,1,4,3,5}, 10));
        System.out.println(new D_1().countSubarrays(new int[]{1,1,1,}, 5));
    }

}
