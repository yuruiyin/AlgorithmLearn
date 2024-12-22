package contest.contest421;

public class A {

    private long lcm(long m, long n) {
        return (m * n) / gcd(m, n);
    }

    private long gcd(long m, long n) {
        if (n == 0) {
            return m;
        }
        return gcd(n, m % n);
    }

    public long maxScore(int[] nums) {
        long lcmValue = nums[0];
        long gcdValue = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            gcdValue = gcd(gcdValue, nums[i]);
            lcmValue = lcm(lcmValue, nums[i]);
        }

        long ans = gcdValue * lcmValue;

        if (len == 1) {
            return ans;
        }

        for (int i = 0; i < len; i++) {
            long lcmValue1 = nums[0];
            long gcdValue1 = nums[0];
            if (i == 0) {
                lcmValue1 = nums[1];
                gcdValue1 = nums[1];
            }
            for (int j = 1; j < len; j++) {
                if (j == i) {
                    continue;
                }
                gcdValue1 = gcd(gcdValue1, nums[j]);
                lcmValue1 = lcm(lcmValue1, nums[j]);
            }
            ans = Math.max(ans, gcdValue1 * lcmValue1);
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
