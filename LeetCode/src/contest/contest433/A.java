package contest.contest433;

public class A {

    public int subarraySum(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int start = Math.max(0, i - nums[i]);
            for (int j = start; j <= i; j++) {
                sum += nums[j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
