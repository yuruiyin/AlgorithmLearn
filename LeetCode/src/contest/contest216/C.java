package contest.contest216;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/22
 */
public class C {

    public int waysToMakeFair(int[] nums) {
        int len = nums.length;
        int[] sufOddSumArr = new int[len];
        int[] sufEvenSumArr = new int[len];
        sufOddSumArr[len - 1] = (len - 1) % 2 == 1 ? nums[len - 1] : 0;
        sufEvenSumArr[len - 1] = (len - 1) % 2 == 0 ? nums[len - 1] : 0;
        for (int i = len - 2; i >= 0; i--) {
            if (i % 2 == 1) {
                sufOddSumArr[i] = sufOddSumArr[i + 1] + nums[i];
                sufEvenSumArr[i] = sufEvenSumArr[i + 1];
            } else {
                sufOddSumArr[i] = sufOddSumArr[i + 1];
                sufEvenSumArr[i] = sufEvenSumArr[i + 1] + nums[i];
            }
        }

        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 1) {
                oddSum += nums[i];
            } else {
                evenSum += nums[i];
            }
        }

        int ans = 0;

        if ((len - 1) % 2 == 1) {
            if (oddSum - nums[len - 1] == evenSum) {
                ans++;
            }
        } else {
            if (evenSum - nums[len - 1] == oddSum) {
                ans++;
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            if (i % 2 == 1) {
                int tmpOddSum = oddSum - nums[i] - sufOddSumArr[i + 1] + sufEvenSumArr[i + 1];
                int tmpEvenSum = evenSum - sufEvenSumArr[i + 1] + sufOddSumArr[i + 1];
                if (tmpEvenSum == tmpOddSum) {
                    ans++;
                }
            } else {
                int tmpOddSum = oddSum - sufOddSumArr[i + 1] + sufEvenSumArr[i + 1];
                int tmpEvenSum = evenSum - nums[i] - sufEvenSumArr[i + 1] + sufOddSumArr[i + 1];
                if (tmpEvenSum == tmpOddSum) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
