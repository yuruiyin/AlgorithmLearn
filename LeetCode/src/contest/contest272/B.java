package contest.contest272;

/**
 * A
 *
 * @author: yry
 * @date: 2021/12/19
 */
public class B {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < spaces.length; i++) {
            int idx = spaces[i];
            if (i == 0) {
                if (idx > 0) {
                    sb.append(s, 0, idx);
                }
                sb.append(" ");
            } else {
                sb.append(s, spaces[i - 1], idx);
                sb.append(" ");
            }
        }
        sb.append(s, spaces[spaces.length - 1], len);
        return sb.toString();
    }

}
