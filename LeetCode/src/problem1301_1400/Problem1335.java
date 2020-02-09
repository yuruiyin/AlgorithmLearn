package problem1301_1400;

public class Problem1335 {

    private int[][] max;
    private int len;
    private Integer[][] memo;

    private int dp(int from, int d) {
        if (from == len) {
            if (d == 0) {
                return 0;
            } else {
                return -1;
            }
        }

        if (d <= 0) {
            return -1;
        }

        if (len - from < d) {
            return -1;
        }

        if (memo[from][d] != null) {
            return memo[from][d];
        }

        int ansMin = Integer.MAX_VALUE;
        for (int i = from; i < len; i++) {
            int res = dp(i + 1, d-1);
            if (res == -1) {
                continue;
            }

            if (res + max[from][i] < ansMin) {
                ansMin = res + max[from][i];
            }
        }

        memo[from][d] = ansMin;
        return ansMin;
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        len = jobDifficulty.length;
        if (len < d) {
            return -1;
        }

        max = new int[len][len];

        for (int i = 0; i < len; i++) {
            max[i][i] = jobDifficulty[i];
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                max[i][j] = Math.max(max[i][j-1], jobDifficulty[j]);
            }
        }

        memo = new Integer[len][d+1];

        return dp(0, d);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1335().minDifficulty(new int[]{6,5,4,3,2,1}, 2));
    }

}

//输入：jobDifficulty = [6,5,4,3,2,1], d = 2
//        输出：7
//        解释：第一天，您可以完成前 5 项工作，总难度 = 6.
//        第二天，您可以完成最后一项工作，总难度 = 1.
//        计划表的难度 = 6 + 1 = 7
