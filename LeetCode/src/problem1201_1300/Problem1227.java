package problem1201_1300;

/**
 * Problem1227
 *
 * @author: yry
 * @date: 2020/4/1
 */
public class Problem1227 {


    public double nthPersonGetsNthSeat(int n) {
        // f(n) = 1 / n + (n - 2) * (1 / n) *  f(n-1)
        double prev = 1;
        double cur = 0;

        for (int i = 2; i <= n; i++) {
            cur = 1.0 / i + (i - 2) * (1.0 / i) * prev;
            prev = cur;
        }

        return prev;
    }

}
