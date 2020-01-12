package problem301_400;

public class Problem318 {

    private int getWordBit(String word) {
        int ans = 0;
        for (char c : word.toCharArray()) {
            ans |= (1 << (c - 'a'));
        }
        return ans;
    }

    public int maxProduct(String[] words) {
        int len = words.length;
        int[] wordBitArr = new int[len];

        for (int i = 0; i < len; i++) {
            wordBitArr[i] = getWordBit(words[i]);
        }

        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((wordBitArr[i] & wordBitArr[j]) == 0) {
                    int multiply = words[i].length() * words[j].length();
                    ansMax = Math.max(ansMax, multiply);
                }
            }
        }
        return ansMax;
    }

}
