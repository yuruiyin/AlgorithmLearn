package problem1101_1200;

public class Problem1137 {

    public int tribonacci(int n) {
        int[] t = new int[37];
        t[0] = 0;
        t[1] = 1;
        t[2] = 1;
        for (int i = 3; i < n; i++) {
            t[i] = t[i-1] + t[i-2] + t[i-3];
        }

        return t[n];
    }

    public int tribonacciV2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (n == 2) {
            return 1;
        }

        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 3; i <= n; i++) {
            c = a + b + c;
            b = c - a - b;
            a = c - a - b;
        }

        return c;
    }

    
    public static void main(String[] args) {

    }
    
}
