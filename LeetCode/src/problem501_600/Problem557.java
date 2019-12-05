package problem501_600;

public class Problem557 {

    public String reverseWords(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }

        StringBuilder ansSb = new StringBuilder();

        int start = -1;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (start != -1) {
                    StringBuilder prevWordSb = new StringBuilder(s.substring(start, i));
                    ansSb.append(prevWordSb.reverse());
                    start = -1;
                }

                ansSb.append(c);
            } else {
                if (i == 0 || s.charAt(i-1) == ' ') {
                    start = i;
                }
            }
        }

        if (s.charAt(len - 1) != ' ') {
            StringBuilder prevWordSb = new StringBuilder(s.substring(start, len));
            ansSb.append(prevWordSb.reverse());
        }

        return ansSb.toString();
    }

}
