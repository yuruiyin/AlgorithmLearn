package contest.contest304;

public class A {

    public int minimumOperations(int[] nums) {
        int ans = 0;
        while (true) {
            boolean isAllZero = true;
            int x = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num != 0) {
                    isAllZero = false;
                    x = Math.min(x, num);
                }
            }
            if (isAllZero) {
                return ans;
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[i] -= x;
                }
            }
            ans++;
        }
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
