package problem201_300;

public class Problem243_1 {

    public int shortestDistance(String[] words, String word1, String word2) {
        int len = words.length;
        String lastWord = null;
        int lastPos = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (lastWord != null && !words[i].equals(lastWord)) {
                    min = Math.min(min, i - lastPos);
                }
                lastWord = words[i];
                lastPos = i;
            }
        }

        return min;
    }

}
