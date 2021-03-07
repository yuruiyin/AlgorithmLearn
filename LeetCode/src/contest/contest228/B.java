package contest.contest228;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/14
 */
public class B {

    private static final int MOD = (int) (1e9 + 7);

    public int countHomogenous(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        long count = 1;
        long sum = 0;

        for (int i = 1; i < len; i++) {
            if (arr[i] != arr[i - 1]) {
                sum = (sum + (count + 1) * count / 2) % MOD;
                count = 1;
            } else {
                count++;
            }
        }

        sum = (sum + (count + 1) * count / 2) % MOD;

        return (int) (sum % MOD);
    }

}
