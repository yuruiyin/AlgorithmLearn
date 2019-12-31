package problem801_900;

public class Problem844_1 {

    public boolean backspaceCompare(String str1, String str2) {
        StringBuilder sb1 = new StringBuilder();
        for (char c : str1.toCharArray()) {
            if (c == '#') {
                if (sb1.length() > 0) {
                    sb1.deleteCharAt(sb1.length() - 1);
                }
            } else {
                sb1.append(c);
            }
        }

        StringBuilder sb2 = new StringBuilder();
        for (char c : str2.toCharArray()) {
            if (c == '#') {
                if (sb2.length() > 0) {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
            } else {
                sb2.append(c);
            }
        }

        return sb1.toString().equals(sb2.toString());
    }

}
