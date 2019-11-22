package problem101_200;

import java.util.ArrayList;
import java.util.List;

public class Problem123 {

    class Sequence {
        int startIndex; // 上升序列在prices中的起始位置
        int endIndex;   // 上升序列在prices中的终止位置
        Sequence(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    private int[] prices;
    private List<Sequence> ascSequenceList; //上升序列列表
    private int ascSequenceListSize;
    private int priceLen;
//    private Map<Long, Integer> memoMap;
    private int[][] memo;

    private int findFirstBigger(List<Sequence> ascSequenceList, int target) {
        int low = 0;
        int high = ascSequenceList.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = ascSequenceList.get(mid).endIndex;
            if (target < midVal) {
                if (mid == 0 || target > ascSequenceList.get(mid - 1).endIndex) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return - 1;
    }

    private int backTrack(int from, int k) {
        if (from >= priceLen - 1 || k == 0) {
            return 0;
        }

        if (memo[from][k-1] != -1) {
            return memo[from][k-1];
        }

        int nextMaxNumIndex = findFirstBigger(ascSequenceList, from);
        if (nextMaxNumIndex == -1) {
            memo[from][k-1] = 0;
            return 0;
        }

        // 判断如果当前剩下的的最大上升序列的个数小于等于当前剩下的交易数的话，那就把后面的所有交易相加返回即可
        int remainingTransactionCount = ascSequenceListSize - nextMaxNumIndex;
        if (remainingTransactionCount <= k) {
            int profit = 0;
            for (int i = nextMaxNumIndex; i < ascSequenceListSize; i++) {
                Sequence sequence = ascSequenceList.get(i);
                profit += prices[sequence.endIndex] - prices[sequence.startIndex];
            }

            memo[from][k-1] = profit;
            return profit;
        }

        int curMinPrice = prices[from];

        // 遍历from后面的上升序列的最大值
        int prevMax = 0;
        int chooseProfitMax = 0;
        // 选择当前为起点的交易
        for (int i = nextMaxNumIndex; i < ascSequenceListSize; i++) {
            Sequence sequence = ascSequenceList.get(i);
            int endIndex = sequence.endIndex;
            if (prices[endIndex] <= prevMax) {
                // 当前上升序列最大的股票价格要大于前一个最大价格，否则没意义
                continue;
            }

            int chooseProfit;
            if (i == ascSequenceListSize - 1) {
                // 后面没有上升序列了
                chooseProfit = prices[endIndex] - curMinPrice;
            } else {
                chooseProfit = backTrack(ascSequenceList.get(i+1).startIndex, k-1) + prices[endIndex] - curMinPrice;
            }

            if (chooseProfit > chooseProfitMax) {
                chooseProfitMax = chooseProfit;
            }

            prevMax = prices[endIndex];
        }

        // 不选当前from为起点的交易
        int totalProfitMax;
        if (nextMaxNumIndex == ascSequenceListSize - 1) {
            totalProfitMax = chooseProfitMax;
        } else {
            Sequence nextSequence = ascSequenceList.get(nextMaxNumIndex+1);
            int nonChooseProfit = backTrack(nextSequence.startIndex, k);
            totalProfitMax = Math.max(chooseProfitMax, nonChooseProfit);
        }

        memo[from][k-1] = totalProfitMax;
        return totalProfitMax;
    }

    public int maxProfit(int k, int[] prices) {
        priceLen = prices.length;
        if (priceLen <= 1) {
            return 0;
        }

        ascSequenceList = new ArrayList<>();

        int startIndex = 0;
        for (int i = 0; i < priceLen - 1; i++) {
            if (i > 0 && prices[i] > prices[i+1] && prices[i] >= prices[i-1]) {
                // 发现一个上升序列
                ascSequenceList.add(new Sequence(startIndex, i));
                startIndex = i + 1;
            } else if (prices[i] > prices[i+1]) {
                startIndex = i + 1;
            }
        }

        if (prices[priceLen - 1] >= prices[priceLen - 2]) {
            ascSequenceList.add(new Sequence(startIndex, priceLen - 1));
        }

        if (ascSequenceList.isEmpty()) {
            // 没有上升序列
            return 0;
        }

        this.prices = prices;
        this.ascSequenceListSize = ascSequenceList.size();
        memo = new int[priceLen][k];
        for (int i = 0; i < priceLen; i++) {
            for (int j = 0; j < k; j++) {
                memo[i][j] = -1;
            }
        }
        return backTrack(ascSequenceList.get(0).startIndex, k);
    }

    public int maxProfit(int[] prices) {
        return maxProfit(2, prices);
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem123().maxProfit(new int[]{2, 1, 4})); // 3
//        System.out.println(new Problem123().maxProfit(new int[]{3,2,6,5,0,3})); //7
//        System.out.println(new Problem123().maxProfit(new int[]{7,4,2,1,11}));  // 10
        System.out.println(new Problem123().maxProfit(new int[]{1,9,6,9,1,7,1,1,5,9,9,9}));  // 16
    }
    
}
