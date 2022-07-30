package doubleContest.round80;

public class D_2 {

    public long countSubarrays(int[] nums, long k) {
        int len = nums.length;
        long ans = 0;
        int newL = 0;
        long preSumR = 0;
        long preSumL = 0;
        for (int r = 0; r < len; r++) {
            preSumR += nums[r];
            for (int l = newL; l <= r; l++) {
                long value = (preSumR - preSumL) * (r - l + 1);
                if (value < k) {
                    ans += (r - l + 1);
                    newL = l;
                    break;
                }
                preSumL += nums[l];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().countSubarrays(new int[]{2,1,4,3,5}, 10));
        System.out.println(new D_2().countSubarrays(new int[]{1,1,1,}, 5));
    }

}
