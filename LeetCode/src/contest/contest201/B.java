package contest.contest201;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/9
 */
public class B {

    private StringBuilder getInvertStr(StringBuilder sb) {
        StringBuilder ansSb = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            ansSb.append(c == '0' ? '1' : '0');
        }
        return ansSb;
    }

    public char findKthBit(int n, int k) {
        String s1 = "0";
        if (n == 1) {
            return '0';
        }

        StringBuilder sb = new StringBuilder(s1);
        while (sb.length() < k) {
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append('1');
            newSb.append(getInvertStr(sb).reverse());
            sb = newSb;
        }

        return sb.charAt(k - 1);
    }

}
