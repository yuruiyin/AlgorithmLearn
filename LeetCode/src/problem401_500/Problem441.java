package problem401_500;

public class Problem441 {

    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + (long) 4 * n * 2) - 1) / 2);
    }

}
