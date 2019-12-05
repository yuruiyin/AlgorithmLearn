package problem501_600;

public class Problem557_1 {

    public String reverseWords(String s) {
        String[] wordArr = s.split(" ");
        StringBuilder ansSb = new StringBuilder();
        int wordSize = wordArr.length;

        for (int i = 0; i < wordSize; i++) {
            StringBuilder wordSb = new StringBuilder(wordArr[i]);
            ansSb.append(wordSb.reverse().toString());
            if (i != wordSize - 1) {
                ansSb.append(" ");
            }
        }

        return ansSb.toString();
    }

}
