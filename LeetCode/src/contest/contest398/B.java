package contest.contest398;

public class B {

    private boolean isOk(int num1, int num2) {
        return (num1 % 2 == 0 && num2 % 2 == 1) || (num1 % 2 == 1 && num2 % 2 == 0);
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (isOk(nums[i], nums[i - 1])) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = i;
            }
        }

        int qLen = queries.length;
        boolean[] ansArr = new boolean[qLen];
        for (int i = 0; i < qLen; i++) {
            int[] q = queries[i];
            int from = q[0];
            int to = q[1];
            ansArr[i] = dp[to] <= from;
        }
        return ansArr;
    }

}
