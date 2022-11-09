package problem801_900;

public class Problem806 {

    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int charWidth = 0;
        for (char c : s.toCharArray()) {
            int w = widths[c - 'a'];
            if (charWidth + w > 100) {
                lines++;
                charWidth = w;
            } else {
                charWidth += w;
            }
        }
        return new int[]{lines, charWidth};
    }

}
