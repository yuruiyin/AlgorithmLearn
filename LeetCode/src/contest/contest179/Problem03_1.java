package contest.contest179;

// 自底向上
public class Problem03_1 {

    private Integer[] memo;
    private int[] manager;
    private int[] informTime;

    private int rec(int cur) {
        if (manager[cur] == -1) {
            return 0;
        }

        if (memo[cur] != null) {
            return memo[cur];
        }

        memo[cur] = informTime[manager[cur]] + rec(manager[cur]);
        return memo[cur];
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // 计算所有的叶子节点到根节点的路径和，取最大
        int ansMax = 0;
        memo = new Integer[n];  // 记忆化
        this.manager = manager;
        this.informTime = informTime;

        for (int i = 0; i < n; i++) {
            if (informTime[i] != 0) { // 不是叶子
                continue;
            }

            // 当前是叶子节点，往上遍历到根
            int sum = rec(i);
            ansMax = Math.max(ansMax, sum);
        }

        return ansMax;
    }

}
