package lcci;

public class Lcci1005 {

    public int findString(String[] words, String s) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(s)) {
                return i;
            }
        }

        return -1;
    }

}
