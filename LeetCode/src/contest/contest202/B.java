package contest.contest202;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/16
 */
public class B {

    public int minOperations(int n) {
        int sum = n + (n - 1) * n;
        int aver = sum / n;
        int idx = 1;
        int ans = 0;
        for (int i = 1; idx <= n; i+=2, idx++) {
            ans += Math.abs(i - aver);
        }

        return ans / 2;
    }

}
