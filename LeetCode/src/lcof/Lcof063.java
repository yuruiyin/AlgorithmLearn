package lcof;

public class Lcof063 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int preMin = prices[0];
        int ansMax = 0;

        for (int i = 1; i < len; i++) {
            ansMax = Math.max(ansMax, prices[i] - preMin);
            preMin = Math.min(preMin, prices[i]);
        }

        return ansMax;
    }

}
