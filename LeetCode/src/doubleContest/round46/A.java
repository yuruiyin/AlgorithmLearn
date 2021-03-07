package doubleContest.round46;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/20
 */
public class A {

    private boolean isOk(char[] arr, int l, int r) {
        boolean[] lowerCountArr = new boolean[26];
        boolean[] upperCountArr = new boolean[26];
        for (int i = l; i <= r; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                lowerCountArr[arr[i] - 'a'] = true;
            } else {
                upperCountArr[arr[i] - 'A'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (lowerCountArr[i] != upperCountArr[i]) {
                return false;
            }
        }
        return true;
    }

    public String longestNiceSubstring(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isOk(arr, i, j)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isOk(arr, i, j)) {
                    if (j - i + 1 == maxLen) {
                        return s.substring(i, j + 1);
                    }
                }
            }
        }

        return "";
    }

}
