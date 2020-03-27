package problem601_700;

/**
 * Problem660_1
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class Problem660_1 {

    public int newInteger(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 9);
            n /= 9;
        }
        return Integer.parseInt(sb.reverse().toString());
    }

}
