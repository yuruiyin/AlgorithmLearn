package problem101_200;

public class Problem174 {

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }

        int m = dungeon.length;
        int n = dungeon[0].length;
        // 右下角（公主的位置）开始dp, 求到达每个位置至少得有多少健康点数
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = dungeon[m-1][n-1] >= 0 ? 1 : -dungeon[m-1][n-1] + 1;

        // 最后一行, 只与右侧有关系
        for (int j = n - 2; j >= 0; j--) {
            dp[m-1][j] = Math.max(dp[m-1][j+1] - dungeon[m-1][j], 1);
        }

        // 最后一列，只与下侧有关系
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n-1] = Math.max(dp[i+1][n-1] - dungeon[i][n-1], 1);
        }

        // 非最后一行和最后一列
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(Math.max(dp[i][j+1] - dungeon[i][j], 1), Math.max(dp[i+1][j] - dungeon[i][j], 1));
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
//        int[][] dungeon = new int[][] {
//                {-2, -3, 3},
//                {-5, -10, 1},
//                {10, 30, -5}
//        };
//        System.out.println(new Problem174().calculateMinimumHP(dungeon));
//
//        int[][] arr = new int[][] {
//                {-3, 5}
//        };
//
//        System.out.println(new Problem174().calculateMinimumHP(arr));
//
//        int[][] arr1 = new int[][] {
//                {1, -3, 3},
//                {0, -2, 0},
//                {-3, -3, -3}
//        };
//
//        System.out.println(new Problem174().calculateMinimumHP(arr1));
//
//        int[][] arr2 = new int[][] {
//                {0, 0, 0},
//                {-1, 0, 0},
//                {2, 0, -2}
//        };
//
//        System.out.println(new Problem174().calculateMinimumHP(arr2));

        int[][] arr3 = new int[][] {
                {1, 2, 1},
                {-2, -3, -3},
                {3, 2, -2}
        };

        System.out.println(new Problem174().calculateMinimumHP(arr3));
    }
}
