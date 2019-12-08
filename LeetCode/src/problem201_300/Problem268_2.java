package problem201_300;

public class Problem268_2 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = n;
        for (int i = 0; i < n; i++) {
            ans ^= i ^ nums[i];
        }
        return ans;
    }

}
