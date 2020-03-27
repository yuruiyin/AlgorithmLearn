package problem001_100;

/**
 * PE001
 *
 * @author: yry
 * @date: 2020/3/27
 */
public class PE001 {

    private int solve(int n) {
        int sum = 0;
        for (int i = 3; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    private int solve1(int n) {
        int sum = 0;
        int x = 3;
        for (int i = 3; i < n; i += 3) {
            sum += i;
        }

        for (int i = 5; i < n; i += 5) {
            sum += i;
        }

        for (int i = 15; i < n; i += 15) {
            sum -= i;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new PE001().solve(1000));
        System.out.println(new PE001().solve1(1000));
    }

}
