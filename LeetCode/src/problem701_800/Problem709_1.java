package problem701_800;

public class Problem709_1 {

    public String toLowerCase(String str) {
        StringBuilder ansSb = new StringBuilder();
        int len = str.length();
        int diff = 'a' - 'A';

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                ansSb.append((char)(c + diff));
            } else {
                ansSb.append(c);
            }
        }

        return ansSb.toString();
    }

}
