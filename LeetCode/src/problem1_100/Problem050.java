package problem1_100;

public class Problem050 {

    public double myPow(double x, int n) {
        double res = 1.0;

        for (int i = n; i != 0; i /= 2) {
            if ((i & 1) == 1) {
                res *= x;
            }

            x *= x;
        }

        return n < 0 ? 1.0 / res : res;
    }

    public static void main(String[] args) {
        System.out.println(new Problem050().myPow(2.0, 10));
        System.out.println(new Problem050().myPow(2.0, -10));
    }

}
