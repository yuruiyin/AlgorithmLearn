package hdu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem2815 {

    private long gcd(long m, long n) {
        if (n == 0) {
            return m;
        }
        return gcd(n, m % n);
    }

    private String getRes(long k, long p, long n) {
        if (k == 1) {
            if (k % p == n) {
                return "0";
            } else {
                return "Orz,I can’t find D!";
            }
        }

        if (n >= p) {
            return "Orz,I can’t find D!";
        }

        long res = k;
        Set<Long> modVisitedSet = new HashSet<>();
        long gcd = gcd(k, p);
        for (int d = 1; ;d++) {
            if (modVisitedSet.contains(res % p)) {
                return "Orz,I can’t find D!";
            }

            if (res % p == n) {
                return String.valueOf(d);
            }

            modVisitedSet.add(res % p);
            res *= k;
            while (res >= k * p) {
                res -= k * p;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long k = scanner.nextLong();
            long p = scanner.nextLong();
            long n = scanner.nextLong();

            System.out.println(new Problem2815().getRes(k, p, n));
        }
    }

}
