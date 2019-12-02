package problem101_200;

import java.util.ArrayList;
import java.util.List;

public class Problem151 {

    public String reverseWords(String s) {
        StringBuilder ansSb = new StringBuilder();
        List<String> ansList = new ArrayList<>();
        int len = s.length();

        StringBuilder tmpSb = null;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (tmpSb != null) {
                    ansList.add(tmpSb.reverse().toString());
                }
                tmpSb = null;
            } else {
                if (tmpSb == null) {
                    tmpSb = new StringBuilder();
                }
                tmpSb.append(c);
            }
        }

        if (tmpSb != null) {
            ansList.add(tmpSb.reverse().toString());
        }

        int size = ansList.size();
        for (int i = 0; i < size; i++) {
            ansSb.append(ansList.get(i));
            if (i != size - 1) {
                ansSb.append(" ");
            }
        }

        return ansSb.toString();
    }

}
