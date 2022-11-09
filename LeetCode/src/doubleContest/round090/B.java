package doubleContest.round090;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class B {

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ansList = new ArrayList<>();
        int len = dictionary.length;
        for (String str : queries) {
            int n = str.length();
            for (int i = 0; i < len; i++) {
                int diff = 0;
                for (int j = 0; j < n; j++) {
                    if (str.charAt(j) != dictionary[i].charAt(j)) {
                        diff++;
                    }
                    if (diff > 2) {
                        break;
                    }
                }
                if (diff <= 2) {
                    ansList.add(str);
                    break;
                }
            }
        }
        return ansList;
    }

}
