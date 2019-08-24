package chapter1;

public class Gcd {

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

    public static void print(int num) {
        System.out.println(num);
    }

    public static void main(String[] args) {
        print(gcd(4, 3));
        print(gcd(6, 4));
        print(gcd(6, 3));
    }

}
