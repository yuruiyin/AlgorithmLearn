package lcof;

public class Lcof058_1_1 {

    public String reverseWords(String s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuilder ansSb = new StringBuilder();
        String[] arr = s.split(" ");
        int len = arr.length;

        for (int i = len - 1; i >= 0; i--) {
            if (!arr[i].equals("")) {
                ansSb.append(arr[i]).append(" ");
            }
        }

        if (ansSb.length() > 0) {
            ansSb.deleteCharAt(ansSb.length() - 1);
        }

        return ansSb.toString();
    }
}
