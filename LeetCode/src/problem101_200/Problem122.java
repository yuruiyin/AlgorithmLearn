package problem101_200;

public class Problem122 {

    public int maxProfit(int[] prices) {
        int ans = 0;
        int len = prices.length;
        if (len == 0) {
            return 0;
        }

        int min = prices[len - 1];
        int max = prices[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            if (prices[i] > prices[i+1]) {
                ans += (max - min);
                min = prices[i];
                max = prices[i];
            } else {
                min = prices[i];
            }
        }

        ans += max - min;

        return ans;
    }
    
    public static void main(String[] args) {

    }
    
}
