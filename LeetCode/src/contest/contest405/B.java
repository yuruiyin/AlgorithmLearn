package contest.contest405;

import java.util.ArrayList;
import java.util.List;

public class B {

    private int n;

    private List<String> ansList;

    private void rec(int idx, StringBuilder sb) {
        if (idx == n) {
            ansList.add(sb.toString());
            return;
        }

        char preChar = sb.charAt(sb.length() - 1);
        if (preChar == '1') {
            sb.append("0");
            rec(idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append("1");
        rec(idx + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public List<String> validStrings(int n) {
        if (n == 1) {
            List<String> ansList = new ArrayList<>();
            ansList.add("0");
            ansList.add("1");
            return ansList;
        }

        this.n = n;
        ansList = new ArrayList<>();
        rec(1, new StringBuilder("0"));
        rec(1, new StringBuilder("1"));
        return ansList;
    }

}
