package lcci;

public class Lcci0103 {

    public String replaceSpaces(String str, int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            sb.append(c == ' ' ? "%20" : c);
        }

        return sb.toString();
    }

}
