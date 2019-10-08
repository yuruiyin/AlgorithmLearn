public class Problem174 {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        if (m == 0) {
            return 0;
        }

        int n = dungeon[0].length;

        if (n == 0) {
            return 0;
        }

        int[][] minDp = new int[m][n];
        int[][] sumDp = new int[m][n];

        minDp[0][0] = dungeon[0][0] > 0 ? 0 : -dungeon[0][0];
        sumDp[0][0] = dungeon[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (i == 0) {
                    sumDp[i][j] = sumDp[i][j - 1] + dungeon[i][j];
                    minDp[i][j] = sumDp[i][j] >= -minDp[i][j - 1] ? minDp[i][j - 1] : -sumDp[i][j];
                } else if (j == 0) {
                    sumDp[i][j] = sumDp[i - 1][j] + dungeon[i][j];
                    minDp[i][j] = sumDp[i][j] >= -minDp[i - 1][j] ? minDp[i - 1][j] : -sumDp[i][j];
                } else {
                    int leftSum = sumDp[i][j - 1] + dungeon[i][j];
                    int topSum = sumDp[i - 1][j] + dungeon[i][j];

                    int leftMin = leftSum >= -minDp[i][j - 1] ? minDp[i][j - 1] : -leftSum;
                    int topMin = topSum >= -minDp[i - 1][j] ? minDp[i - 1][j] : -topSum;

                    if (i == m - 1 && j == n - 1) {
                        minDp[i][j] = Math.min(leftMin, topMin);
                    } else {
                        if (leftSum - leftMin == topSum - topMin) {
                            minDp[i][j] = leftSum > topSum ? leftMin : topMin;
                        } else if (leftSum - leftMin > topSum - topMin) {
                            minDp[i][j] = leftMin;
                        } else {
                            minDp[i][j] = topMin;
                        }
                    }

                    if (minDp[i][j] == leftMin) {
                        sumDp[i][j] = leftSum;
                    } else {
                        sumDp[i][j] = topSum;
                    }
                }
            }
        }

        if (minDp[m - 1][n - 1] <= 0) {
            return 1;
        }

        return minDp[m - 1][n - 1] + 1;
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
