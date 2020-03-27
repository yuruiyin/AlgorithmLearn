package problem001_100;

/**
 * PE004
 *
 * @author: yry
 * @date: 2020/3/27
 */
public class PE004 {

    private boolean isPalindrome(long num) {
        char[] arr = String.valueOf(num).toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // n代表位数
    private long solve(int n) {
        long max = (int) (Math.pow(10, n) - 1);
        long min = (int) Math.pow(10, n - 1);

        long maxPrime = 0;
        for (long i = max; i >= min; i--) {
            for (long j = max; j >= min; j--) {
                if (i * j > maxPrime && isPalindrome(i * j)) {
                    maxPrime = Math.max(maxPrime, i * j);
                    break;
                }
            }
        }

        return maxPrime;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            System.out.println(new PE004().solve(i));
        }
    }

}
