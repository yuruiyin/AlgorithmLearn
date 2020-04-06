package contest.contest183;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/5
 */
public class D {

    private int[] arr;
    private int len;
    private Integer[][] memo;

    private int dp(int idx, int alice) {
        if (idx == len) {
            return 0;
        }

        if (memo[idx][alice] != null) {
            return memo[idx][alice];
        }

        if (alice == 1) {
            if (idx <= len - 3) {
                // 可以取1，2，3堆
                int res1 = arr[idx] + dp(idx + 1, 0);
                int res2 = arr[idx] + arr[idx + 1] + dp(idx + 2, 0);
                int res3 = arr[idx] + arr[idx + 1] + arr[idx + 2] + dp(idx + 3, 0);
                int res = Math.max(res1, Math.max(res2, res3));
                memo[idx][alice] = res;
                return res;
            } else if (idx <= len - 2) {
                // 可以取1，2堆
                int res1 = arr[idx] + dp(idx + 1, 0);
                int res2 = arr[idx] + arr[idx + 1] + dp(idx + 2, 0);
                int res = Math.max(res1, res2);
                memo[idx][alice] = res;
                return res;
            } else {
                // 可以取1堆
                int res = arr[idx] + dp(idx + 1, 0);
                memo[idx][alice] = res;
                return res;
            }
        } else {
            if (idx <= len - 3) {
                // 可以取1，2，3堆
                int res1 = dp(idx + 1, 1);
                int res2 = dp(idx + 2, 1);
                int res3 = dp(idx + 3, 1);
                int res = Math.min(res1, Math.min(res2, res3));
                memo[idx][alice] = res;
                return res;
            } else if (idx <= len - 2) {
                // 可以取1，2堆
                int res1 = dp(idx + 1, 1);
                int res2 = dp(idx + 2, 1);
                int res = Math.min(res1, res2);
                memo[idx][alice] = res;
                return res;
            } else {
                // 可以取1堆
                int res = dp(idx + 1, 1);
                memo[idx][alice] = res;
                return res;
            }
        }
    }

    public String stoneGameIII(int[] stoneValue) {
        arr = stoneValue;
        len = arr.length;
        memo = new Integer[len][2];
        int totalScore = 0;
        for (int i = 0; i < len; i++) {
            totalScore += stoneValue[i];
        }

        int aliceScore = dp(0, 1);
        if (aliceScore > totalScore - aliceScore) {
            return "Alice";
        } else if (aliceScore < totalScore - aliceScore) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

}
