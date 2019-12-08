package problem201_300;

public class Problem268_1 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int needSum = n * (n + 1) / 2;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        return needSum - sum;
    }

}
