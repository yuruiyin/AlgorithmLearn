package baidu_star.precontest1;

import java.util.Scanner;

public class Problem01 {

    private int gcd(int m, int n) {
        if (n == 0) {
            return m;
        }
        return gcd(n, m % n);
    }

    private String getMinScore(int m, int n) {
        int gcd = gcd(m, n);
        int top = m / gcd;
        int bottom = n / gcd;
        return top + "/" + bottom;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while ((t--) > 0) {
            int n = scan.nextInt();
            int[] f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = scan.nextInt();
            }

            int[] g = new int[n];
            for (int i = 0; i < n; i++) {
                g[i] = scan.nextInt();
            }


            for (int i = n - 1; i >= 0; i--) {
                if (f[i] == 0 && g[i] != 0) {
                    System.out.println("0/1");
                    break;
                }

                if (f[i] != 0 && g[i] == 0) {
                    System.out.println("1/0");
                    break;
                }

                if (f[i] != 0 && g[i] != 0) {
                    System.out.println(new Problem01().getMinScore(f[i], g[i]));
                    break;
                }
            }

        }
    }

}
