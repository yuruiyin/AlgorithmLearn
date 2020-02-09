package problem1301_1400;

import java.util.ArrayList;
import java.util.List;

public class Problem1324 {

    // 删除尾随空格
    private String removeSuffixSpaces(StringBuilder sb) {
        while (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public List<String> printVertically(String s) {
        String[] str = s.split(" ");
        int wordLen = str.length;

        int maxLen = 0;
        for (String word : str) {
            maxLen = Math.max(maxLen, word.length());
        }

        List<String> ansList = new ArrayList<>();
        for (int j = 0; j < maxLen ;j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < wordLen; i++) {
                if (str[i].length() <= j) {
                    sb.append(' ');
                } else {
                    sb.append(str[i].charAt(j));
                }
            }

            ansList.add(removeSuffixSpaces(sb));
        }

        return ansList;
    }

}
