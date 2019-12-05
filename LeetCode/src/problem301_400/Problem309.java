package problem301_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem309 {

    // prices数组中的每个元素右边比他大的元素的索引列表
    private List<Integer>[] rightBiggerIndexList;
    private int[] prices;
    private int len;
    private int[] memo;

    private int backTrack(int from) {
        if (from >= len) {
            return 0;
        }

        if (memo[from] != -1) {
            return memo[from];
        }

        // 选或不选当前股票买入
        int curPrice = prices[from];
        List<Integer> rightBiggers = rightBiggerIndexList[from];
        int chooseMaxProfit = Integer.MIN_VALUE;
        for (Integer rightIndex: rightBiggers) {
            int chooseProfit = 0;
            chooseProfit += (prices[rightIndex] - curPrice);
            chooseProfit += backTrack(rightIndex + 2);
            if (chooseProfit > chooseMaxProfit) {
                chooseMaxProfit = chooseProfit;
            }
        }

        int nonChooseProfit = backTrack(from+1);
        memo[from] = Math.max(chooseMaxProfit, nonChooseProfit);
        return memo[from];
    }

    public int maxProfit(int[] prices) {
        len = prices.length;
        this.prices = prices;
        rightBiggerIndexList = new ArrayList[len];

        for (int i = 0; i < len; i++) {
            rightBiggerIndexList[i] = new ArrayList<>();
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (prices[j] > prices[i]) {
                    rightBiggerIndexList[i].add(j);
                }
            }
        }

        memo = new int[len];
        Arrays.fill(memo, -1);
        return backTrack(0);
    }

}
