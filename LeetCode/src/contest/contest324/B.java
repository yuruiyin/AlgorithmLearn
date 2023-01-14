package contest.contest324;

import java.util.ArrayList;
import java.util.List;

public class B {

    private final static List<Integer> allPrimes = new ArrayList<>();

    private boolean isPrime(int num) {
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int smallestValue(int n) {
        if (allPrimes.isEmpty()) {
            for (int i = 2; i <= 100000; i++) {
                if (isPrime(i)) {
                    allPrimes.add(i);
                }
            }
        }

//        System.out.println(allPrimes.size());

        int lastN = n;

        while (n > 1 && !isPrime(n)) {
            int max = (int) Math.sqrt(n);
            int sum = 0;
            for (int prime : allPrimes) {
                if (prime > max) {
                    break;
                }
                while (n % prime == 0) {
                    sum += prime;
                    n /= prime;
                }
            }
            if (n > 1) {
                sum += n;
            }
            n = sum;
            if (n == lastN) {
                break;
            }
            lastN = n;
        }
        return n;
    }

    public static void main(String[] args) {
        new B().smallestValue(15);
        System.out.println("hello world");
    }

}
