package contest.contest332;

public class A {

    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            if (l == r) {
                ans += nums[l];
            } else {
                ans += Integer.parseInt(String.valueOf(nums[l]) + String.valueOf(nums[r]));
            }
            l++;
            r--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
