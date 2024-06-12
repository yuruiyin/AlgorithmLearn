package problem2801_2900;

public class Problem2806 {

    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int left = purchaseAmount / 10 * 10;
        int mod = purchaseAmount % 10;
        return 100 - (left + (mod >= 5 ? 10 : 0));
    }

}
