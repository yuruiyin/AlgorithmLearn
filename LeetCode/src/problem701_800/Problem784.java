package problem701_800;

import java.util.ArrayList;
import java.util.List;

public class Problem784 {

    private static final int LOWER_UPPER_DIFF = 'a' - 'A';

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private char convertLetterCase(char c) {
        if (c >= 'a') {
            return (char) (c - LOWER_UPPER_DIFF);
        }

        return (char) (c + LOWER_UPPER_DIFF);
    }

    private void backTrack(int index, String s, StringBuilder sb, List<String> ansList) {
        if (index == s.length()) {
            ansList.add(sb.toString());
            return;
        }

        char c = s.charAt(index);

        if (isNumber(c)) {
            sb.append(c);
            backTrack(index + 1, s, sb, ansList);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        // 字母
        // 不转
        sb.append(c);
        backTrack(index + 1, s, sb, ansList);
        sb.deleteCharAt(sb.length() - 1);
        // 转
        sb.append(convertLetterCase(c));
        backTrack(index + 1, s, sb, ansList);
        sb.deleteCharAt(sb.length() - 1);
    }

    public List<String> letterCasePermutation(String s) {
        List<String> ansList = new ArrayList<>();
        backTrack(0, s, new StringBuilder(), ansList);
        return ansList;
    }
    
    public static void main(String[] args) {
        List<String> ansList = new Problem784().letterCasePermutation("a1b2");
        
        for (String str: ansList) {
            System.out.print(str + ",");
        }
        
        System.out.println();
    }
    
}

