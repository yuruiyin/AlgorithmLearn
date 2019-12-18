package problem201_300;

import java.util.ArrayList;
import java.util.List;

public class Problem249 {

    private boolean isMatch(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int strLen = str1.length();
        for (int k = 1; k < strLen; k++) {
            char curC1 = str1.charAt(k);
            char prevC1 = str1.charAt(k-1);
            char curC2 = str2.charAt(k);
            char prevC2 = str2.charAt(k-1);
            if ((curC1 - prevC1 + 26) % 26 != (curC2 - prevC2 + 26) % 26) {
                return false;
            }
        }

        return true;
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ansList = new ArrayList<>();
        int len = strings.length;
        boolean[] visited = new boolean[len];

        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            List<String> list = new ArrayList<>();
            list.add(strings[i]);
            ansList.add(list);
            for (int j = i + 1; j < len; j++) {
               if (isMatch(strings[i], strings[j])) {
                    list.add(strings[j]);
                    visited[j] = true;
               }
            }
        }

        return ansList;
    }

}
