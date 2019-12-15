package problem1001_1100;

public class Problem1049_2 {

    private int[] stones;
    private int len;

    private boolean helper(int from, int sum, int target) {
        if (sum == target) {
            return true;
        }

        if (sum > target || from == len) {
            return false;
        }

        return helper(from + 1, sum + stones[from], target)
                || helper(from + 1, sum, target);
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        this.stones = stones;
        this.len = stones.length;
        for (int stone : stones) {
            sum += stone;
        }

        int halfSum = sum >>> 1;
        for (int i = halfSum; ;i--) {
            if (helper(0, 0, i)) {
                return sum - 2 * i;
            }
        }
    }

}
