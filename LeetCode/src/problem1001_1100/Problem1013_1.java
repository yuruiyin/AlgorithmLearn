package problem1001_1100;

public class Problem1013_1 {

    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if (sum % 3 != 0) {
            return false;
        }

        int onePartSum = sum / 3;
        int len = arr.length;
        int preSum = arr[0];
        boolean hasOneParSum = preSum == onePartSum;
        for (int i = 1; i < len - 1; i++) {
            preSum += arr[i];
            if (preSum == 2 * onePartSum && hasOneParSum) {
                return true;
            }

            if (preSum == onePartSum) {
                hasOneParSum = true;
            }
        }

        return false;
    }

}
