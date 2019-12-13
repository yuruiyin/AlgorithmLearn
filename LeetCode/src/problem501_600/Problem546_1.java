package problem501_600;

public class Problem546_1 {

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        // dp(l, r, k) l代表序列起始位置，r代表序列终止位置，k代表该序列右侧有多少个与第r个元素相等的元素
        int[][][] dp = new int[n][n][n];
        return dfs(boxes, dp, 0, boxes.length - 1, 0);
    }

    private int dfs(int[] boxes, int[][][] dp, int l, int r, int k) {
        if (l > r) {
            return 0;
        }

        while (r > l && boxes[r] == boxes[r-1]) {
            r--;
            k++;
        }

        if (dp[l][r][k] != 0) {
            return dp[l][r][k];
        }

        // 移除末尾元素
        dp[l][r][k] = dfs(boxes, dp, l, r - 1, 0) + (k + 1) * (k + 1);

        // 遍历这个序列，找到与boxes[r]相等的元素，然后进行移除，求最大值即可
        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                // 移除第i+1到r-1之间的元素
                dp[l][r][k] = Math.max(dp[l][r][k], dfs(boxes, dp, l, i, k+1) + dfs(boxes, dp, i+1, r-1, 0));
            }
        }

        return dp[l][r][k];
    }

}
