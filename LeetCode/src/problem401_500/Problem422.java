package problem401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem422
 *
 * @author: yry
 * @date: 2020/3/26
 */
public class Problem422 {

    public boolean validWordSquare(List<String> words) {
        int m = words.size();
        List<String> colWords = new ArrayList<>();

        for (int j = 0; ;j++) {
            StringBuilder sb = new StringBuilder();
            boolean hasChar = false;
            for (int i = 0; i < m; i++) {
                String tmpWord = words.get(i);
                if (tmpWord.length() <= j) {
                    break;
                }
                hasChar = true;
                sb.append(tmpWord.charAt(j));
            }

            colWords.add(sb.toString());
            if (!hasChar) {
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            String rowWord = words.get(i);
            String colWord = colWords.get(i);
            if (!rowWord.equals(colWord)) {
                return false;
            }
        }

        return true;
    }

}
