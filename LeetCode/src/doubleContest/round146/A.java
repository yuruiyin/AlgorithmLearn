package doubleContest.round146;

public class A {

    public int countSubarrays(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i <= len - 3; i++) {
            if ((nums[i] + nums[i + 2]) * 2 == nums[i + 1]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
