package problem101_200;

public class Problem121 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = prices[j] - prices[i];
                if (diff > max) {
                    max = diff;
                }
            }
        }

        return max;
    }
    
    public static void main(String[] args) {

    }
}
