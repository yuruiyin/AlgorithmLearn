package problem001_100;

import java.util.List;

/**
 * PE003
 *
 * @author: yry
 * @date: 2020/3/27
 */
public class PE003 {

    private boolean isPrime(long num) {
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private long  solve(long n) {
        if (isPrime(n)) {
            return n;
        }

        int end = (int) Math.sqrt(n);
        int maxPrime = 0;
        for (int i = 2; i <= end; i++) {
            if (n % i == 0) {
                if (isPrime(n / i)) {
                    return n / i;
                }

                if (isPrime(i)) {
                    maxPrime = i;
                }
            }
        }

        return maxPrime;
    }
    
    public static void main(String[] args) {
        System.out.println(new PE003().solve(600851475143L));
    }
    
}
