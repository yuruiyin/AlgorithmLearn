package contest.contest129;

public class Problem1013 {

    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if (sum % 3 != 0) {
            return false;
        }

        int eachSum = sum / 3;
        int sum1 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
            if (sum1 == eachSum) {
                int sum2 = 0;
                for (int j = i + 1; j < arr.length; j++) {
                    sum2 += arr[j];
                    if (sum2 == eachSum && j != arr.length - 1) {
                        return true;
                    }
                }
                return false;
            }
        }

        return false;
    }

}
