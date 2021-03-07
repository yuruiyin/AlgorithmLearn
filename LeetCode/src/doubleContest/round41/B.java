package doubleContest.round41;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/12
 */
public class B {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length;
        int[] preSumArr = new int[len];
        int[] sufSumArr = new int[len];

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }

        sufSumArr[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            sufSumArr[i] = sufSumArr[i + 1] + nums[i];
        }

        int[] ansArr = new int[len];
        ansArr[0] = sum - nums[0] * len;
        ansArr[len - 1] = nums[len - 1] * len - sum;

        for (int i = 1; i < len - 1; i++) {
            ansArr[i] += nums[i] * (i + 1) - preSumArr[i];
            ansArr[i] += sufSumArr[i] - nums[i] * (len - i);
        }

        return ansArr;
    }

}
