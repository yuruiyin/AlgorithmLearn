package problem901_1000;

public class Problem983 {

    private int[] days;
    private int dayLen;
    private int[] costs;
    private Integer[] memo;

    private int dp(int idx) {
        if (idx == dayLen) {
            return 0;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        // 三种票
        int res1 = dp(idx + 1) + costs[0];
        int curDay = days[idx];
        int nextIdx2;
        for (nextIdx2 = idx; nextIdx2 < dayLen; nextIdx2++) {
            if (days[nextIdx2] > curDay + 6) {
                break;
            }
        }

        int res2 = dp(nextIdx2) + costs[1];

        int nextIdx3;
        for (nextIdx3 = idx; nextIdx3 < dayLen; nextIdx3++) {
            if (days[nextIdx3] > curDay + 29) {
                break;
            }
        }

        int res3 = dp(nextIdx3) + costs[2];

        memo[idx] = Math.min(res1, Math.min(res2, res3));

        return memo[idx];
    }

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.dayLen = days.length;
        this.costs = costs;
        memo = new Integer[dayLen];
        return dp(0);
    }

}

//在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
//
//        火车票有三种不同的销售方式：
//
//        一张为期一天的通行证售价为 costs[0] 美元；
//        一张为期七天的通行证售价为 costs[1] 美元；
//        一张为期三十天的通行证售价为 costs[2] 美元。
//        通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
//
//        返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
//
//
//
//        示例 1：
//
//        输入：days = [1,4,6,7,8,20], costs = [2,7,15]
//        输出：11
//        解释：
//        例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
//        在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
//        在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
//        在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
//        你总共花了 $11，并完成了你计划的每一天旅行。
