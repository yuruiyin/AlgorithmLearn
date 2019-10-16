package problem301_400;

public class Problem374 {

    private int guess(int num) {
        if (num == 6) {
            return 0;
        }

        return 6 < num ? -1 : 1;
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem374().guessNumber(10));
    }

}
