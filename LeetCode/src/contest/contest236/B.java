package contest.contest236;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/11
 */
public class B {

    public int findTheWinner(int n, int k) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + k) % i;
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        System.out.println("1");
    }

}
