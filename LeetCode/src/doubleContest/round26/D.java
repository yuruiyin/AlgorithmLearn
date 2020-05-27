package doubleContest.round26;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/16
 */
public class D {

    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[5000 + 1];
        int len = cost.length;

        for (int i = 0; i < len; i++) {
            dp[cost[i]] = 1;
        }

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                if (dp[j] > 0 && dp[i - j] > 0) {
                    dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
                }
            }
        }

        int target1 = target;

        // 求count个数的cost和等于target
        int[] countArr = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int curCount = -1;
            for (int j = 1; ; j++) {
                if (j > dp[target1] || j * cost[i] > target1) {
                    break;
                }

                if (j == dp[target1]) {
                    if (target1 == j * cost[i]) {
                        curCount = j;
                    }
                    break;
                }

                if (dp[target1] - j == dp[target1 - j * cost[i]]) {
                    curCount = j;
                }
            }

            if (curCount == -1) {
                continue;
            }

            target1 = target1 - curCount * cost[i];
            countArr[i] = curCount;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            int tmpCount = countArr[i];
            while ((tmpCount--) > 0) {
                sb.append(i + 1);
            }
        }

        return sb.toString().isEmpty() ? "0" : sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new D().largestNumber(new int[]{
                4,3,2,5,6,7,2,5,5
        }, 9));
    }

}
