package contest.contest302;

public class B {

    private int getSum(int num) {
        int ans = 0;
        while (num > 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }

    public int maximumSum(int[] nums) {
        int[] maxArr = new int[100];
        int len = nums.length;
        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            int sum = getSum(nums[i]);
            if (maxArr[sum] > 0) {
                ansMax = Math.max(ansMax, maxArr[sum] + nums[i]);
            }
            maxArr[sum] = Math.max(maxArr[sum], nums[i]);
        }
        return ansMax == 0 ? -1 : ansMax;
    }

}
