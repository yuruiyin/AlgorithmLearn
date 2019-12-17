package problem201_300;

public class Problem245 {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        int len = words.length;
        String lastWord = words[0];
        int lastPos = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < len; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (words[i].equals(word1) && lastWord.equals(word2) || words[i].equals(word2) && lastWord.equals(word1)) {
                    min = Math.min(min, i - lastPos);
                }
                lastWord = words[i];
                lastPos = i;
            }
        }

        return min;
    }

}
