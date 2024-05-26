package contest.contest368;

public class A {

    public int minimumSum(int[] nums) {
        int len = nums.length;
        int sum = Integer.MAX_VALUE;
        for (int i = 1; i < len - 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    for (int k = i + 1; k < len; k++) {
                        if (nums[i] > nums[k]) {
                            sum = Math.min(sum, nums[i] + nums[j] + nums[k]);
                        }
                    }
                }
            }
        }
        return sum == Integer.MAX_VALUE ? -1 : sum;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
