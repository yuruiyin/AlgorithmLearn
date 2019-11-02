package problem001_100;

public class Problem053_1 {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int prevMax = nums[0];
        int ans = prevMax;

        for (int i = 1; i < n; i++) {
            prevMax = prevMax > 0 ? prevMax + nums[i] : nums[i];
            if (prevMax > ans) {
                ans = prevMax;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {

    }
    
}
