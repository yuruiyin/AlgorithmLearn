package contest.contest302;

import java.util.Arrays;

public class D {

    private long gcd(long m, long n) {
        if (n == 0) {
            return m;
        }
        return gcd(n, m % n);
    }

    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        long gcd1 = numsDivide[0];
        for (int num : numsDivide) {
            gcd1 = gcd(gcd1, num);
        }
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (gcd1 % nums[i] == 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().minOperations(new int[]{2,3,2,4,3}, new int[]{9,6,9,3,15}));
    }

}
