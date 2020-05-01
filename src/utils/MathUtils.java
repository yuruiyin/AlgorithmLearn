package utils;

import java.util.ArrayList;
import java.util.List;

public class MathUtils {

    // 求n以内的所有素数
    private List<Integer> getAllPrimes(int n, boolean[] isNotPrime) {
        for (int i = 2; i * i <= n; i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= n; j += i) {
                isNotPrime[j] = true;
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    // 快速幂
    public static int pow(long x, long n, int mod) {
        long res = 1;
        x %= mod;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x % mod;
            }

            x = x * x % mod;
            n >>>= 1;
        }
        return (int) res % mod;
    }

    // 二分法求平方根
    public static double sqrt(double n) {
        double low = 0;
        double high = n;
        double epr = 1e-6;
        double mid = low + (high - low) / 2;
        while (Math.abs(mid * mid - n) > epr) {
            if (mid > n / mid) {
                high = mid;
            } else {
                low = mid;
            }
            mid = low + (high - low) / 2;
        }
        return mid;
    }

    public static int mySqrt(int n) {
        double low = 0;
        double high = n;
        double epr = 1e-6;
        double mid = low + (high - low) / 2;
        while (Math.abs(mid * mid - n) > epr) {
            if (mid > n / mid) {
                high = mid;
            } else {
                low = mid;
            }
            mid = low + (high - low) / 2;
        }
        return (int) (mid + epr);
    }
    
    public static void main(String[] args) {
        System.out.println(sqrt(12.25));
        System.out.println(sqrt(1));
    }

}
