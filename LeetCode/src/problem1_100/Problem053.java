package problem1_100;

public class Problem053 {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int ansMax = nums[0];
        int prevMax = nums[0];

        for (int i = 1; i < n; i++) {
            prevMax = prevMax > 0 ? nums[i] + prevMax : nums[i];
            if (prevMax > ansMax) {
                ansMax = prevMax;
            }
        }

        return ansMax;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem053().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
