package problem501_600;

public class Problem557_2 {

    public String reverseWords(String s) {
        StringBuilder ansSb = new StringBuilder();
        int len = s.length();

        for (int i = 0; i < len;) {
            int end = s.indexOf(" ", i);
            if (end == -1) {
                // 最后一个单词
                end = len;
            }
            StringBuilder wordSb = new StringBuilder(s.substring(i, end));
            ansSb.append(wordSb.reverse());
            if (end != len) {
                ansSb.append(" ");
            }
            i = end + 1;
        }

        return ansSb.toString();
    }

}
