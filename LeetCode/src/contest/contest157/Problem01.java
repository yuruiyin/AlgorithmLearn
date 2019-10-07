package contest.contest157;

public class Problem01 {

    public int minCostToMoveChips(int[] chips) {
        int n = chips.length;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i ++) {
            int cost = 0;
            for (int j = 0; j < n; j++) {
                if ((chips[j] - chips[i]) % 2 != 0) {
                    cost++;
                }
            }

            if (cost < min) {
                min = cost;
            }
        }

        return min;
    }

    /**
     * 统计奇数和偶数个数，取最小就是要求的值
     * 思路：奇数 - 奇数 = 偶数，奇数 - 偶数 = 奇数， 偶数 - 偶数 = 偶数。而只有奇数才会产生代价。因此只要至少统计需要多少次奇数和偶数相减即可
     * 假设奇数个数少，那么奇数和偶数相减的次数就是其数的次数。
     * @param chips
     * @return
     */
    public int minCostToMoveChips1(int[] chips) {
        int odd = 0;

        for (int item: chips) {
            if ((item & 1) == 1) {
                odd++;
            }
        }

        return Math.min(odd, chips.length - odd);
    }

    public static void main(String[] args) {

    }

}
