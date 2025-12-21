package contest.contest463;

public class A {

    public long maxProfit(int[] prices, int[] strategy, int k) {
        long sum = 0;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            sum += (long) prices[i] * strategy[i];
        }

        long[] preSumArr = new long[len];
        preSumArr[0] = prices[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + prices[i];
        }

        long[] preSumArr1 = new long[len];
        preSumArr1[0] = (long) prices[0] * strategy[0];
        for (int i = 1; i < len; i++) {
            preSumArr1[i] = preSumArr1[i - 1] + (long) prices[i] * strategy[i];
        }

        long ansMax = sum;
        for (int i = 0; i + k <= len; i++) {
            // 前 k/2[i, i + k / 2 - 1] 设置为 0
            long leftDiff = -(preSumArr1[i + k / 2 - 1] - (i == 0 ? 0 : preSumArr1[i - 1]));
            // 后 k/2[i + k / 2, i + k - 1] 设置为1
            long rightDiff = preSumArr[i + k - 1] - preSumArr[i + k / 2 - 1] -(preSumArr1[i + k - 1] - preSumArr1[i + k / 2 - 1]);
            ansMax = Math.max(ansMax, sum + leftDiff + rightDiff);
        }

        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
