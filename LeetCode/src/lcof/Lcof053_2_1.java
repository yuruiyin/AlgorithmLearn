package lcof;

public class Lcof053_2_1 {

    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }

        return (n + 1) * n / 2 - sum;
    }

}
