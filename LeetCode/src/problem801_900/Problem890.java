package problem801_900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem890 {

    private boolean isMatch(String word, String p) {
        int len = word.length();
        int[] map = new int[256];
        Arrays.fill(map, -1);
        boolean[] visited = new boolean[256];
        for (int i = 0; i < len; i++) {
            char wordChar = word.charAt(i);
            char pChar = p.charAt(i);

            if (map[wordChar] != -1) {
                if (map[wordChar] != pChar) {
                    return false;
                }
            } else {
                if (visited[pChar]) {
                    return false;
                }
            }

            map[wordChar] = pChar;
            visited[pChar] = true;
        }

        return true;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ansList = new ArrayList<>();
        for (String word : words) {
            if (isMatch(word, pattern)) {
                ansList.add(word);
            }
        }
        return ansList;
    }

}
