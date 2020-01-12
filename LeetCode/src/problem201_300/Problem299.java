package problem201_300;

public class Problem299 {

    public String getHint(String secret, String guess) {
        int len = secret.length();
        int[] countArr = new int[10];
        for (char c : secret.toCharArray()) {
            countArr[c - '0']++;
        }

        int sameCount = 0;
        int hasCount = 0;
        for (int i = 0; i < len; i++) {
            char guessChar = guess.charAt(i);
            if (secret.charAt(i) == guessChar) {
                sameCount++;
                countArr[guessChar - '0']--;
            }
        }

        for (int i = 0; i < len; i++) {
            char guessChar = guess.charAt(i);
            if (guessChar != secret.charAt(i) && countArr[guessChar - '0'] > 0) {
                hasCount++;
                countArr[guessChar - '0']--;
            }
        }

        return sameCount + "A" + hasCount + "B";
    }

}
