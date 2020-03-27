package problem001_100;

/**
 * PE006
 *
 * @author: yry
 * @date: 2020/3/27
 */
public class PE006 {

    private int solve(int n) {
        int squareSum = n * (n + 1) * (2 * n + 1) / 6;
//        for (int i = 1; i <= n; i++) {
//            squareSum += i * i;
//        }
        int sum = n * (n + 1) / 2;
        int sumSquare = sum * sum;
        return sumSquare - squareSum;
    }
    
    public static void main(String[] args) {
        System.out.println(new PE006().solve(10));
        System.out.println(new PE006().solve(100));
    }
    
}
