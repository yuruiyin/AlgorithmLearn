package lcof;

public class Lcof005 {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                sb.replace(i, i + 1, "%20");
            }
        }
        return sb.toString();
    }

}
