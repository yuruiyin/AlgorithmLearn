package contest.contest311;

public class A {

    private int gcd(int m, int n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }

    public int smallestEvenMultiple(int n) {
        return 2 * n / gcd(n, 2);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
