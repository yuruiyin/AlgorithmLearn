package problem301_400;

public class Problem367_1 {

    public boolean isPerfectSquare(int num) {
        long low = 0;
        long high = num;
        while (low <= high) {
            long mid = low + ((high - low) >>> 1);
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem367_1().isPerfectSquare(16));
    }

}
