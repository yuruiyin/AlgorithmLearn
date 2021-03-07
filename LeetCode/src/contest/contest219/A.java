package contest.contest219;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/13
 */
public class A {

    public int numberOfMatches(int n) {
        int ans = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n >>>= 1;
                ans += n;
            } else {
                ans += ((n - 1) >>> 1);
                n = ((n - 1) >>> 1) + 1;
            }
        }
        return ans;
    }

}
