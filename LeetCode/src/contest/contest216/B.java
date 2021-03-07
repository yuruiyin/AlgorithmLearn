package contest.contest216;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/22
 */
public class B {

    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        long sum = 0;

        while (sb.length() < n) {
            if (sb.length() == n - 1) {
                sb.append((char)((k - sum - 1) + 'a'));
                break;
            }
            int i;
            for (i = 1; i <= 26; i++) {
                if (k - (sum + i) <= (n - sb.length() - 1) * 26) {
                    sum += i;
                    break;
                }
            }

            sb.append((char) ((i - 1) + 'a'));
        }

        return sb.toString();
    }

}
