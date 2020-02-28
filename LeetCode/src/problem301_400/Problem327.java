package problem301_400;

public class Problem327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        int ansCount = 0;

        for (int i = 0; i < len; i++) {
            long sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) {
                    ansCount++;
                }
            }
        }

        return ansCount;
    }

}
