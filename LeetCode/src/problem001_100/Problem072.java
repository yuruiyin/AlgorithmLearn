package problem001_100;

public class Problem072 {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        if (len1 == 0) {
            return len2;
        }

        if (len2 == 0) {
            return len1;
        }

        int[][] minDist = new int[len1][len2];

        minDist[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;

        for (int i = 1; i < len1; i++) {
            if (word2.charAt(0) != word1.charAt(i)) {
                minDist[i][0] = minDist[i-1][0] + 1;
            } else {
                minDist[i][0] = i;
            }
        }

        for (int j = 1; j < len2; j++) {
            if (word1.charAt(0) != word2.charAt(j)) {
                minDist[0][j] = minDist[0][j-1] + 1;
            } else {
                minDist[0][j] = j;
            }
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    minDist[i][j] = Math.min(Math.min(minDist[i-1][j] + 1, minDist[i][j-1] + 1), minDist[i-1][j-1]);
                } else {
                    minDist[i][j] = Math.min(Math.min(minDist[i-1][j] + 1, minDist[i][j-1] + 1), minDist[i-1][j-1] + 1);
                }
            }
        }

        return minDist[len1-1][len2-1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem072().minDistance("horse", "ros"));
        System.out.println(new Problem072().minDistance("intention", "execution"));
        System.out.println(new Problem072().minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));

    }
    
}
