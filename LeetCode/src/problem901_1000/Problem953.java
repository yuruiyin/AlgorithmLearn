package problem901_1000;

public class Problem953 {

    public boolean isAlienSorted(String[] words, String order) {
        int[] indexArr = new int[26];
        char[] orderArr = order.toCharArray();
        for (int i = 0; i < orderArr.length; i++) {
            indexArr[orderArr[i] - 'a'] = i;
        }

        int len = words.length;
        for (int i = 1; i < len; i++) {
            String preWord = words[i-1];
            String curWord = words[i];
            int preWordLen = preWord.length();
            int curWordLen = curWord.length();
            int minLen = Math.min(preWordLen, curWordLen);
            int j;
            for (j = 0; j < minLen; j++) {
                if (indexArr[curWord.charAt(j) - 'a'] < indexArr[preWord.charAt(j) - 'a']) {
                    return false;
                } else if (indexArr[curWord.charAt(j) - 'a'] > indexArr[preWord.charAt(j) - 'a']) {
                    break;
                }
            }

            if (j == minLen && preWordLen > curWordLen) {
                return false;
            }
        }

        return true;
    }

}
