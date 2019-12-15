package problem1001_1100;

public class Problem1049_1 {

    private int[] stones;
    private int len;
    private int[][] memo;

    private int backTrack(int from, int sum) {
        if (sum == 0) {
            return 0;
        }

        if (from == len || sum < 0) {
            return -1;
        }

        if (memo[from][sum] != -2) {
            return memo[from][sum];
        }

        int chooseRes = backTrack(from + 1, sum - stones[from]);
        if (chooseRes != -1) {
            chooseRes += stones[from];
        }
        int nonChooseRes = backTrack(from + 1, sum);

        memo[from][sum] = Math.max(chooseRes, nonChooseRes);
        return memo[from][sum];
    }

    // 转化为01背包问题，即石头分两堆，让两队的石头各自的总重量都接近一半的总重量
    public int lastStoneWeightII(int[] stones) {
        this.stones = stones;
        len = stones.length;
        int sum = 0;
        for (int stone: stones) {
            sum += stone;
        }

        // 从重量的一半开始，递减寻找最接近重量一半的一堆石头
        int halfSum = sum >>> 1;
        memo = new int[len][halfSum+1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= halfSum; j++) {
                memo[i][j] = -2;
            }
        }

        for (int i = halfSum;;i--) {
            int ans = backTrack(0, i);
            if (ans != -1) {
                return Math.abs(sum -  ans - ans);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1049_1().lastStoneWeightII(new int[]{3,3,6,4,8,8}));
    }

}
