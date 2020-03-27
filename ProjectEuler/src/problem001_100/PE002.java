package problem001_100;

/**
 * PE002
 *
 * @author: yry
 * @date: 2020/3/27
 */
public class PE002 {

    private int solve(int n) {
        int num1 = 1;
        int num2 = 2;
        int sum = 0;
        while (num2 <= n) {
            if ((num2 & 1) == 0) {
                sum += num2;
            }

            int oldNum2 = num2;
            num2 = num1 + num2;
            num1 = oldNum2;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new PE002().solve(4000000));
    }

}
