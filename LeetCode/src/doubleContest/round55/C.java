package doubleContest.round55;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/26
 */
public class C {

    public long maxAlternatingSum(int[] nums) {
        int len = nums.length;
        long ansMax = 0;
        for (int num : nums) {
            ansMax = Math.max(ansMax, num);
        }

        long sum = 0;
        int flag = 0;
        for (int i = 1; i < len; i++) {
            if (flag == 0) {
                if (nums[i] < nums[i - 1]) {
                    sum += nums[i - 1];
                    flag = 1;
                } else {
                    if (i == len - 1) {
                        sum += nums[i];
                    }
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    sum -= nums[i - 1];
                    if (i == len - 1) {
                        sum += nums[i];
                    }
                    flag = 0;
                }
            }
        }

        return Math.max(sum, ansMax);

    }

}
