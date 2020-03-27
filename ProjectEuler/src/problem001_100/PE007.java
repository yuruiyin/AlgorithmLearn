package problem001_100;

/**
 * PE007
 *
 * @author: yry
 * @date: 2020/3/27
 */
public class PE007 {

    private boolean isPrime(int n) {
        int end = (int) Math.sqrt(n);
        for (int i = 2; i <= end; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int solve(int n) {
        int primeIdx = 0;
        for (int i = 2; ;i++) {
            if (isPrime(i)) {
                primeIdx++;
                if (primeIdx == n) {
                    return i;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new PE007().solve(10001));
    }

}
