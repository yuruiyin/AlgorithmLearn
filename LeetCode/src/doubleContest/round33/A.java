package doubleContest.round33;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/22
 */
public class A {

    public String thousandSeparator(int n) {
        String str = String.valueOf(n);
        int len = str.length();
        StringBuilder sb = new StringBuilder();

        if (len % 3 != 0) {
            sb.append(str, 0, len % 3);
        }

        for (int i = len % 3; i < len; i+=3) {
            if (sb.length() != 0) {
                sb.append('.');
            }
            sb.append(str, i, i + 3);
        }

        return sb.toString();
    }

}
