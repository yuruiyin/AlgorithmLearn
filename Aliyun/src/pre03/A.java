package pre03;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/5
 */
public class A {

    private long gcd(long m, long n) {
        if (n == 0) {
            return m;
        }
        return gcd(n, m % n);
    }

    /**
     * @param a: Left margin
     * @param b: Right margin
     * @return: return the greatest common multiple
     */
    public long greatestcommonmultiple(int a, int b) {
        // write your code here
        long num = b * (b - 1);
        long ansMax = 0;
        for (int i = b - 2; i >= a; i--) {
            ansMax = Math.max(ansMax, num * i / gcd(num, i));
        }
        return ansMax;
    }
    
    public static void main(String[] args) {
        System.out.println(new A().greatestcommonmultiple(1, 6));
        System.out.println(new A().greatestcommonmultiple(7, 10));
    }

}
