package test;

/**
 * Test20200604
 *
 * @author: yry
 * @date: 2020/6/4
 */
public class Test20200604 {

    private static int f(int n) {
        return n == 1 ? 1 : ((n / 2) % 2 == 0 ? n - f(n - 2) : -(n - f(n - 2)));
    }

    public static void main(String[] args) {
        System.out.println(f(101));
    }

}
