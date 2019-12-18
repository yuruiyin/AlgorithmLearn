package problem201_300;

public class Problem259 {

    public int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                for (int k = j+1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] < target) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

}
