package contest.contest319;

public class B {

    private long gcd(long m, long n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }

    public int subarrayLCM(int[] nums, int k) {
        int len = nums.length;
        int ans = 0;
        if (nums[0] == k) {
            ans++;
        }
        for (int i = 1; i < len; i++) {
            long gcd1 = nums[i];
            long lcm = nums[i];
            if (nums[i] == k) {
                ans++;
            }
            for (int j = i - 1; j >= 0; j--) {
                gcd1 = gcd(nums[j], lcm);
                lcm = lcm * nums[j] / gcd1;
                if (lcm > k) {
                    break;
                }
                if (lcm == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = i + 1;
        }
        System.out.println(new B().subarrayLCM(new int[]{3, 6, 2, 7, 1}, 6));
//        System.out.println(new B().subarrayLCM(arr, 6));
    }

}
