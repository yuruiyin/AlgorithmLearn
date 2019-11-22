package problem101_200;

import java.util.*;

public class Problem188 {

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
    private Map<Long, Integer> memoMap;
    private int oldK;
    private int[] ascSequenceSumArr; // 上升序列的profit和，第i个元素从当前元素到末尾的profit和

    private int backTrack(int priceIndex, int ascSequenceIndex, int k) {
        if (priceIndex >= priceLen - 1 || ascSequenceIndex >= ascSequenceListSize || k == 0) {
            return 0;
        }

        long key = priceIndex * oldK + k;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        // 判断如果当前剩下的的最大上升序列的个数小于等于当前剩下的交易数的话，那就把后面的所有交易相加返回即可
        int remainingTransactionCount = ascSequenceListSize - ascSequenceIndex;
        if (remainingTransactionCount <= k) {
            int profit = ascSequenceSumArr[ascSequenceIndex];
            memoMap.put(key, profit);
            return profit;
        }

        int curMinPrice = prices[priceIndex];

        // 遍历from后面的上升序列的最大值
        int prevMax = 0;
        int chooseProfitMax = 0;
        // 选择当前为起点的交易
        for (int i = ascSequenceIndex; i < ascSequenceListSize; i++) {
            Sequence sequence = ascSequenceList.get(i);
            int startIndex = sequence.startIndex;
            int endIndex = sequence.endIndex;
            if (prices[endIndex] <= prevMax || curMinPrice > prices[startIndex]) {
                // 当前上升序列最大的股票价格要大于前一个最大价格，否则没意义
                // 同时，当前上升序列的最小价格如果小于curMinPrice，也直接跳过
                continue;
            }

            int chooseProfit;
            if (i == ascSequenceListSize - 1) {
                // 后面没有上升序列了
                chooseProfit = prices[endIndex] - curMinPrice;
            } else {
                chooseProfit = backTrack(ascSequenceList.get(i+1).startIndex, i+1, k-1) + prices[endIndex] - curMinPrice;
            }

            if (chooseProfit > chooseProfitMax) {
                chooseProfitMax = chooseProfit;
            }

            prevMax = prices[endIndex];
        }

        // 不选当前from为起点的交易
        int totalProfitMax;
        if (ascSequenceIndex == ascSequenceListSize - 1) {
            totalProfitMax = chooseProfitMax;
        } else {
            Sequence nextSequence = ascSequenceList.get(ascSequenceIndex+1);
            int nonChooseProfit = backTrack(nextSequence.startIndex, ascSequenceIndex+1,  k);
            totalProfitMax = Math.max(chooseProfitMax, nonChooseProfit);
        }

        memoMap.put(key, totalProfitMax);
        return totalProfitMax;
    }

    /**
     * 计算上升序列的效益和
     */
    private void calcAscSequenceSumArr() {
        int len = ascSequenceListSize;
        ascSequenceSumArr = new int[len];
        Sequence lastSequence = ascSequenceList.get(len - 1);
        ascSequenceSumArr[len - 1] = prices[lastSequence.endIndex] - prices[lastSequence.startIndex];
        for (int i = len - 2; i >= 0; i--) {
            Sequence sequence = ascSequenceList.get(i);
            ascSequenceSumArr[i] = ascSequenceSumArr[i+1] + prices[sequence.endIndex] - prices[sequence.startIndex];
        }
    }

    public int maxProfit(int k, int[] prices) {
        this.oldK = k;
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

        this.ascSequenceListSize = ascSequenceList.size();
        this.prices = prices;
        memoMap = new HashMap<>();
        k = Math.min(ascSequenceListSize, k);
        calcAscSequenceSumArr();

        return backTrack(ascSequenceList.get(0).startIndex, 0, k);
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem188().maxProfit(2, new int[]{2,4,1}));
        System.out.println(new Problem188().maxProfit(6, new int[]{8,3,6,2,8,8,8,4,2,0,7,2,9,4,9}));
    }
    
}
