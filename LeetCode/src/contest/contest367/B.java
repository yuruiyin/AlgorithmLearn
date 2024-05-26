package contest.contest367;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class B {

    public String shortestBeautifulSubstring(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        List<String> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int oneCount = 0;
            if (arr[i] != '1') {
                continue;
            }
            for (int j = i; j < len; j++) {
                if (arr[j] == '1') {
                    oneCount++;
                    if (oneCount == k) {
                        list.add(s.substring(i, j + 1));
                        break;
                    }
                }
            }
        }

        if (list.isEmpty()) {
            return "";
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
            }
        });
        return list.get(0);
    }

}
