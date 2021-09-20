package contest.contest238;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/11
 */
public class A {

    public int sumBase(int n, int k) {
        int sum = 0;
        while (n > 0) {
            sum += n % k;
            n /= k;
        }
        return sum;
    }

}
