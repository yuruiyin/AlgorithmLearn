package problem501_600;

/**
 * Problem509_1
 *
 * @author: yry
 * @date: 2020/3/26
 */
public class Problem509_1 {

    public int fib(int n) {
        if (n <= 1) return n;
        double sqrt5 = Math.sqrt(5);
        double x1 = (1 + sqrt5) / 2;
        double x2 = (1 - sqrt5) / 2;
        return (int) ((Math.pow(x1, n) - Math.pow(x2, n)) / sqrt5);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem509_1().fib(40));
    }

}
