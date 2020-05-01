package doubleContest.round24;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/18
 */
public class C {

    private List<String> list;
    private int len;
    private int k;
    private boolean isOk = false;

    private void dfs(char preC, int idx, StringBuilder tmpSb) {
        if (isOk) {
            return;
        }

        if (idx == len) {
            list.add(tmpSb.toString());
            if (list.size() >= k) {
                isOk = true;
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            char nextC = (char) ('a' + i);
            if (nextC == preC) {
                continue;
            }

            tmpSb.append(nextC);
            dfs(nextC, idx + 1, tmpSb);
            tmpSb.deleteCharAt(tmpSb.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {
        len = n;
        this.k = k;
        list = new ArrayList<>();

        dfs(' ', 0, new StringBuilder());
        if (list.size() >= k) {
            return list.get(k - 1);
        }
        return "";
    }

}
