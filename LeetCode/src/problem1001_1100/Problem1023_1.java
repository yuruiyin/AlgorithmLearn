package problem1001_1100;

import java.util.ArrayList;
import java.util.List;

public class Problem1023_1 {

    private boolean isMatch(String query, String pattern) {
        int i = 0;
        int pLen = pattern.length();
        for (char c : query.toCharArray()) {
            if (i < pLen) {
                if (c == pattern.charAt(i)) {
                    i++;
                } else if (c < 'a') {
                    return false;
                }
            } else {
                if (c < 'a') {
                    return false;
                }
            }
        }

        return i == pLen;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ansList = new ArrayList<>();

        for (String query: queries) {
            ansList.add(isMatch(query, pattern));
        }

        return ansList;
    }

}
