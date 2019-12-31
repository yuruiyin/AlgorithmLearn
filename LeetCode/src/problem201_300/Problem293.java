package problem201_300;

import java.util.ArrayList;
import java.util.List;

public class Problem293 {

    public List<String> generatePossibleNextMoves(String s) {
        List<String> ansList = new ArrayList<>();
        int len = s.length();

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                ansList.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }

        return ansList;
    }

}
