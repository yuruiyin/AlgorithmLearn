package contest.contest167;

public class Problem03_1 {

    public int maxSideLength(int[][] mat, int threshold) {
        int ans = 0;
        int[][] dp = new int[mat.length+1][mat[0].length+1];
        int dpRowCount = dp.length;
        int dpColCount = dp[0].length;
        for (int y = 1; y < dpRowCount; y++) {
            for (int x = 1; x < dpColCount; x++) {
                if(mat[y-1][x-1]>threshold){
                    continue;
                }
                //dp[y][x]表示以y，x为右下角的正方形中，不大于阈值的最大边长
                dp[y][x] = Math.min(Math.min(dp[y-1][x],dp[y][x-1]),dp[y-1][x-1])+1;
                //加上当前节点后，有可能超过阈值，因此需要重新计算最大边长
                int sum=0;
                for (int i = 0; i < dp[y][x]; i++) {
                    for (int j = 0; j < dp[y][x]; j++) {
                        sum+=mat[y-1-i][x-1-j];
                    }
                }
                int yy=y-1-dp[y][x]+1;
                int xx=x-1-dp[y][x]+1;
                //从左上角沿着对角线，开始一层一层减掉，直到总和小于阈值
                while (sum>threshold){
                    for (int i=yy; i < y; i++) {
                        sum-=mat[i][xx];
                    }
                    for (int i = xx+1; i <x; i++) {
                        sum-=mat[yy][i];
                    }
                    yy++;
                    xx++;
                }
                dp[y][x]=y-yy;
                ans= Math.max(dp[y][x],ans);
            }
        }
        return ans;
    }

}
