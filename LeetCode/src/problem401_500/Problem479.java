package problem401_500;

public class Problem479 {

    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int max = (int) (Math.pow(10, n) - 1);

        for (int i = max - 1; i > max / 10; i--) {
            String str = String.valueOf(i);
            long palindromeStr = Long.parseLong(str + new StringBuilder(str).reverse().toString());

            for (long x = max; x * x >= palindromeStr; x--) {
                if (palindromeStr % x == 0) {
                    return (int) (palindromeStr % 1337);
                }
            }
        }

        return -1;
    }

}
