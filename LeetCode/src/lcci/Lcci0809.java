package lcci;

import java.util.ArrayList;
import java.util.List;

public class Lcci0809 {

    private int n;
    private List<String> ansList;

    private void backTrack(int lCount, int rCount, StringBuilder tmpSb) {
        if (rCount > lCount) {
            return;
        }

        if (lCount > n) {
            return;
        }

        if (tmpSb.length() == 2 * n) {
            ansList.add(tmpSb.toString());
            return;
        }

        tmpSb.append('(');
        backTrack(lCount + 1, rCount, tmpSb);
        tmpSb.deleteCharAt(tmpSb.length() - 1);

        tmpSb.append(')');
        backTrack(lCount, rCount + 1, tmpSb);
        tmpSb.deleteCharAt(tmpSb.length() - 1);
    }

    public List<String> generateParenthesis(int n) {
        this.n = n;
        ansList = new ArrayList<>();
        backTrack(0, 0, new StringBuilder());
        return ansList;
    }

}
